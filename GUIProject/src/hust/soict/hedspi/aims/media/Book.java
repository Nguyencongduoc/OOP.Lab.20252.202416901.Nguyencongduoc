package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Overloaded constructor used by GUI code
    public Book(String title, String category, float cost, String author, String format) {
        this(0, title, category, cost);
        if (author != null && !author.isEmpty()) {
            addAuthor(author);
        }
        // format ignored for now
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }
    @Override
    public String toString() {
        // authors.toString() sẽ in danh sách tác giả ngăn cách bởi dấu phẩy
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors.toString() + ": " + getCost() + " $";
    }
}