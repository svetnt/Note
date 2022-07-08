package src.repository.impl;

import src.model.Note;
import src.repository.NoteRepository;

import java.util.HashSet;
import java.util.Set;

public class NoteRepositoryImpl implements NoteRepository {

    private static final Set<Note> NOTES = new HashSet<>(); // Используем множество, а не список или массив, т.к.
    // хотим хранить только уникальные заметки. Уникальность заметок
    // определяется с помощью методов Note#equals и Note#hashcode.

    private static final NoteRepositoryImpl SINGLETON = new NoteRepositoryImpl();   // Используем паттерн singleton,
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

