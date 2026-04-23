package src.hust.soict.hedspi.aims.store;

import src.hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

    public class Store {
        private ArrayList<Media> itemsInStore = new ArrayList<>();

        // Thêm Media vào kho
        public void addMedia(Media media) {
            if (!itemsInStore.contains(media)) {
                itemsInStore.add(media);
                System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
            } else {
                System.out.println("The media '" + media.getTitle() + "' is already in the store.");
            }
        }

        public void removeMedia(Media media) {
            if (itemsInStore.remove(media)) {
                System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
            } else {
                System.out.println("The media '" + media.getTitle() + "' is not in the store.");
            }
        }
        public void displayStore() {
            System.out.println("********************STORE********************");
            if (itemsInStore.isEmpty()) {
                System.out.println("The store is empty.");
            } else {
                System.out.println("Items in store:");
                for (int i = 0; i < itemsInStore.size(); i++) {
                    // Nhờ tính đa hình, gọi toString() sẽ in ra đúng định dạng của DVD, Book hoặc CD
                    System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
                }
            }
            System.out.println("*********************************************");
        }

        public Media searchByTitle(String title) {
            for (Media media : itemsInStore) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    return media;
                }
            }
            return null;
        }
    }
