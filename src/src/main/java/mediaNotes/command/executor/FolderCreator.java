package mediaNotes.command.executor;

import mediaNotes.command.CommandType;
import mediaNotes.model.Folder;
import mediaNotes.model.Note;

public class FolderCreator extends AbstractCommandExecutor{

    @Override
    public int execute(String command) {
        return createFolder(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_FOLDER;
    }

    private int createFolder(String command) {
        var wordsArray = command.split(" ");

        var folderName = wordsArray[2];

        var noteParrentFolder=wordsArray[3];
        var folder=findFolder(noteParrentFolder);

        if (folder.isEmpty()) {
            System.out.println("Folder not exists");
            return -1;
        }

        var newFolder = new Folder(folderName, folder.get());

        folderRepository.save(newFolder);

        System.out.println("New folder created");

        return 1;
    }
}
