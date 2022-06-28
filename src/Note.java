import java.time.Instant;

public class Note {

    private final String name;

    private String text;

    private final String author;

    private final Instant creationDate;
    Instant updateDate;

    public Note(String name, String text) {
        this.name = name;
        this.text = text;
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
}
