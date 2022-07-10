package mediaNotes.model;

import java.time.Instant;
import java.util.Objects;

public class Note {

    private Folder parentFolder;

    private final String name;

    private String text;

    private final String author;

    private final Instant creationDate;
    Instant updateDate;

    public Note(String name, String text, Folder parentFolder) {
        this.name = name;
        this.text = text;
        this.parentFolder=parentFolder;
        author=null;
        creationDate=Instant.now();
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }

    public String getAuthor() {
        return author;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(name, note.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
