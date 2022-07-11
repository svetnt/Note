package mediaNotes.command.executor;

import mediaNotes.command.CommandType;
import mediaNotes.context.UserContext;
import mediaNotes.model.Note;

import java.awt.*;
import java.util.Comparator;
import java.util.stream.Collectors;

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

        var list = noteRepository.findAll().
                stream().
                collect(Collectors.toList());

        var isNeedFilter = command.contains("-f");

        var isNeedSorted = command.contains("-s");

        var userEmail = UserContext.getUserLogin();

        if (isNeedFilter) {
            list = list
                    .stream()
                    .filter(p -> p.equals(userEmail))
                    .collect(Collectors.toList());
            ;
        }

        if (isNeedSorted) {
            list = list
                    .stream()
                    .sorted(Comparator.comparing(Note::getCreationDate))
                    .collect(Collectors.toList());
        }

        for (Note el : list) {
            var patch = findFolderPath(el.getName());
            System.out.printf("Title: \"%s\". Text: \"%s\".%n Patch: \"%s\".\n", el.getName(), el.getText(), patch);
        }

        return 1;
    }
}

