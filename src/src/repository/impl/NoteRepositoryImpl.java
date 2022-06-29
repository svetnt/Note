package src.repository.impl;

import src.Note;
import src.repository.NoteRepository;

import java.util.LinkedList;
import java.util.List;

public class NoteRepositoryImpl implements NoteRepository {

    private static final List<Note> NOTES = new LinkedList<>();

    @Override
    public Note save(Note note) {
        NOTES.add(note);
        return note;
    }
}
