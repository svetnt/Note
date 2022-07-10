package mediaNotes.repository.impl;

import mediaNotes.model.Note;
import mediaNotes.repository.NoteRepository;

import java.util.HashSet;
import java.util.Set;

public class NoteRepositoryImpl implements NoteRepository {

    private static final Set<Note> NOTES = new HashSet<>();
    // хотим хранить только уникальные заметки. Уникальность заметок
    // определяется с помощью методов Note#equals и Note#hashcode.

    private static final NoteRepositoryImpl SINGLETON = new NoteRepositoryImpl();
    // паттерн singleton,
    // то есть когда мы создаем внутри класса ровно 1 объект
    // на все приложение и потом выдаем его другим классам, чтобы они его использовали.
    // При этом прячем конструктор, делая его приватным.

    private NoteRepositoryImpl() {}

    public static NoteRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Note> findAll() {
        return NOTES;
    }

    @Override
    public void save(Note note) {
        NOTES.add(note);
    }

    @Override
    public void remove(Note note) {
        NOTES.remove(note);
    }
}

