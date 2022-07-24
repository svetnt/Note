package mediaNotes.repository.impl;

import mediaNotes.model.Folder;
import mediaNotes.model.Note;
import mediaNotes.repository.FolderRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FolderRepositoryImpl implements FolderRepository {

    private static final Set<Folder> FOLDERS=new HashSet<>();

    /*static {
        loadDataFromFile();
        if (FOLDERS.stream()
                .noneMatch(p -> p.getName().equals("root"))) {
            FOLDERS.add(new Folder("root", null));
        }
    }*/
    static {
        loadDataFromFile();

       if (FOLDERS.stream().noneMatch(folder -> folder.getName().equals("root"))) {
            FOLDERS.add(new Folder("root", null));
        }
    }

    private static final FolderRepository SINGLETON = new FolderRepositoryImpl();

    private FolderRepositoryImpl() {
    }

    public static FolderRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Folder> findAll() {
        return FOLDERS;
    }

    @Override
    public void save(Folder newFolder) {
        FOLDERS.add(newFolder);
        saveDataToFile();
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data-folder.dat"))) {
            stream.writeObject(FOLDERS);
        } catch (FileNotFoundException e) {
            System.out.println("oops");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadDataFromFile() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("data-folder.data"))) {
            Set<Folder> loadSet = (Set<Folder>) stream.readObject();
            System.out.println("Содержание папок прочитано: "+loadSet.size());
           FOLDERS.addAll(loadSet);
        } catch (FileNotFoundException ex) {
            System.out.println("ooops");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
