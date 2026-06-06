package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class Cart {

    // Change ArrayList → ObservableList so TableView can observe changes
    private ObservableList<Media> itemsOrdered =
            FXCollections.observableArrayList();

    /** New accessor required by CartController */
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added '" + media.getTitle() + "' to cart.");
        } else {
            System.out.println("The media is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed '" + media.getTitle() + "'.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i));
            }
            System.out.printf("Total cost: %.2f $%n", calculateTotalCost());
        }
        System.out.println("***************************************************");
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    // Phương thức tìm kiếm Media theo ID
    public void searchById(int id) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found match for ID " + id + ": " + media.toString());
                matchFound = true;
                break; // ID thường là duy nhất nên tìm thấy thì thoát vòng lặp luôn
            }
        }
        if (!matchFound) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Phương thức tìm kiếm Media theo Tiêu đề (Title)
    public void searchByTitle(String title) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            // Dùng equalsIgnoreCase để tìm kiếm không phân biệt hoa/thường
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found match for title '" + title + "': " + media.toString());
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("No match found for title: " + title);
        }
    }
}