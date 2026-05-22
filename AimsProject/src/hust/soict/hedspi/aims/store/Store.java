package src.hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import src.hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // ---- CRUD -------------------------------------------------------
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        } else {
            System.out.println("Item already exists in store.");
        }
    }

    public boolean removeMedia(Media media) {
        return itemsInStore.remove(media);
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public int getSize() {
        return itemsInStore.size();
    }

    // ---- Print (CLI helper, kept for backward compatibility) --------
    public void printStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, itemsInStore.get(i));
        }
        System.out.println("***************************************************");
    }
}