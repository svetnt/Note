package mediaNotes.command.executor;

import mediaNotes.model.Folder;
import mediaNotes.model.Note;
import mediaNotes.repository.FolderRepository;
import mediaNotes.repository.NoteRepository;
import mediaNotes.repository.impl.FolderRepositoryImpl;
import mediaNotes.repository.impl.NoteRepositoryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCommandExecutor implements CommandExecutor {

    protected final NoteRepository noteRepository = NoteRepositoryImpl.getSingleton();
    protected final FolderRepository folderRepository= FolderRepositoryImpl.getSingleton();

    protected Optional<Note> findNote(String noteName) {
        for (Note note : noteRepository.findAll()) {
            if (note.getName().equals(noteName)) {
                return Optional.of(note);
            }
        }
        return Optional.empty();
    }

    protected Optional<Folder> findFolder(String folderName){
        for (Folder folder: folderRepository.findAll()){
            if (folder.getName().equals(folderName)){
                return Optional.of(folder);
            }
        }
        return Optional.empty();
    }

    protected List<String> findFolderPath(String name) {
        var note = findNote(name);
        if (note.isEmpty()) {
            return null;
        }
        return findFolderPath(note.get());
    }

    private List<String> findFolderPath(Note note) {
        List<String> path = new LinkedList<>();
        findFolderPath(note.getParentFolder(), path);
        return path;
    }

    private void findFolderPath(Folder folder, List<String> path) {
        path.add(folder.getName());
        if (folder.getParentFolder() != null) {
            findFolderPath(folder.getParentFolder(), path);
        }
    }
}
