package src.repository;

import src.model.Folder;

import java.util.Set;

public interface FolderRepository {

    Set<Folder> findAll();

    void save(Folder newFolder);
}
