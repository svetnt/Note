package mediaNotes.command.executor;

import mediaNotes.command.CommandType;
import mediaNotes.model.Note;

import java.util.Optional;

public class NoteDeleter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return deleteNote(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_NOTE;
    }

    private int deleteNote(String command) {
        var wordsArray = command.split(" ");

        var noteNameToRemove = wordsArray[2];

        Optional<Note> noteToRemove = findNote(noteNameToRemove);

        if (noteToRemove.isPresent()) {
            noteRepository.remove(noteToRemove.get());

            System.out.println("Note deleted");
        } else {
            System.out.println("Note not found");
        }

        return 1;
    }
}
