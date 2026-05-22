package src.hust.soict.hedspi.aims.media;
public class Book extends Media {
    private String author;
    private String coverType; // e.g. "Paperback", "Hardcover"

    public Book() {}

    public Book(String title, String category, float cost,
                String author, String coverType) {
        super(title, category, cost);
        this.author    = author;
        this.coverType = coverType;
    }

    // ---- Getters / Setters ------------------------------------------
    public String getAuthor()    { return author;    }
    public String getCoverType() { return coverType; }

    public void setAuthor   (String author)    { this.author    = author;    }
    public void setCoverType(String coverType) { this.coverType = coverType; }

    @Override
    public String toString() {
        return String.format("Book[title=\"%s\", author=%s, coverType=%s, cost=%.2f]",
                getTitle(), author, coverType, getCost());
    }
}