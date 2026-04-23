package src.hust.soict.hedspi.aims.cart;

import src.hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to cart.");
        } else {
            System.out.println("The media is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media '" + media.getTitle() + "' has been removed.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // 1. Hàm in danh sách giỏ hàng
    public void print() {
        System.out.println("***********************CART***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Ordered Items:");
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
            System.out.println("Total cost: " + calculateTotalCost() + " $");
        }
        System.out.println("***************************************************");
    }

    // 2. Tìm kiếm Media theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found item with ID " + id + ":");
                System.out.println(media.toString());
                found = true;
                break; // Tìm thấy thì dừng luôn vì ID là duy nhất
            }
        }
        if (!found) {
            System.out.println("No item with ID " + id + " found in the cart.");
        }
    }

    // 3. Tìm kiếm Media theo Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found item matching title \"" + title + "\":");
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item matching title \"" + title + "\" found in the cart.");
        }
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo Tiêu đề (A-Z) -> Giá (Giảm dần).");
    }
    // --- THÊM 2 HÀM SẮP XẾP NÀY VÀO CUỐI LỚP CART ---
    // Sắp xếp theo Giá rồi đến Tiêu đề [cite: 1340]
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo Giá (Giảm dần) -> Tiêu đề (A-Z).");
    }
    // Phương thức làm trống giỏ hàng
    public void emptyCart() {
        itemsOrdered.clear();
    }
}