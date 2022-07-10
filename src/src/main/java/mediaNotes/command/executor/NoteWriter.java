package mediaNotes.command.executor;

import mediaNotes.command.CommandType;
import mediaNotes.model.Note;

public class NoteWriter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return writeNotes(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_NOTES;
    }

    private int writeNotes(String command) {
        for (Note note : noteRepository.findAll()) {
            var patch=findFolderPath(note.getName());
            System.out.printf("Title: \"%s\". Text: \"%s\".%n Patch: \"%s\".\n", note.getName(), note.getText(),patch);
        }

        return 1;
    }
}

