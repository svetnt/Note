package src;

import src.Authentification;
import src.repository.NoteRepository;
import src.repository.impl.NoteRepositoryImpl;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int code = Authentification.autentificate();
        System.out.println(code == 0 ? "Login success" : "Login failed");


        Note note1 = new Note("заметка 1", "написать приложение \"Заметки\"");
        Note note2 = new Note("заметка 2", "заметки сохранять в коллекции");
        Note note3 = new Note("заметка 3", "в приложении должна быть аутентификация");

        NoteRepository noteRepository=new NoteRepositoryImpl();

        noteRepository.save(note1);
        noteRepository.save(note2);
        noteRepository.save(note3);


    }
}
