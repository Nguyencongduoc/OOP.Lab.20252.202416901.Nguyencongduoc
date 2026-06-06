package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    /** Required by ViewStoreController */
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added '" + media.getTitle() + "' to store.");
        } else {
            System.out.println("'" + media.getTitle() + "' is already in store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed '" + media.getTitle() + "' from store.");
        } else {
            System.out.println("'" + media.getTitle() + "' not found in store.");
        }
    }

    public void displayStore() {
        System.out.println("********************STORE********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
        System.out.println("*********************************************");
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }
}