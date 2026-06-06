package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store   store   = new Store();
    private static Cart    cart    = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // ── Dữ liệu mẫu ─────────────────────────────────────────────────────
        DigitalVideoDisc dvd = new DigitalVideoDisc(
                1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        Book book = new Book(2, "Java Programming", "Education", 25.0f);
        CompactDisc cd = new CompactDisc(
                3, "Greatest Hits", "Music", 15.0f, "Director A", "Artist X");
        cd.addTrack(new Track("Track 1", 180));
        cd.addTrack(new Track("Track 2", 200));

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: viewStore();  break;
                case 2: updateStore(); break;
                case 3: viewCart();   break;
                case 0: System.out.println("Tạm biệt!"); break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    // ── Menu chính ────────────────────────────────────────────────────────────

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // ── Store ─────────────────────────────────────────────────────────────────

    public static void viewStore() {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: seeMediaDetails();   break;
                case 2: addMediaToCart();    break;
                case 3: playMediaInStore();  break;
                case 4: viewCart();          break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose: 0-1-2-3-4: ");
    }

    private static void seeMediaDetails() {
        System.out.print("Nhập tiêu đề Media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Không tìm thấy sản phẩm này.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("\nOptions:");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            System.err.println("Lỗi phát: " + e.getMessage());
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private static void addMediaToCart() {
        System.out.print("Nhập tiêu đề sản phẩm muốn thêm: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Sản phẩm không có trong kho.");
        }
    }

    private static void playMediaInStore() {
        System.out.print("Nhập tiêu đề sản phẩm muốn Play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println("Lỗi phát: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Sản phẩm này không thể phát.");
        }
    }

    public static void updateStore() {
        System.out.println("1. Thêm Media vào kho | 2. Xóa Media khỏi kho | 0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Chức năng đang phát triển...");
                break;
            case 2:
                System.out.print("Nhập tiêu đề Media muốn xóa: ");
                String title = scanner.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null) {
                    store.removeMedia(media);
                } else {
                    System.out.println("Không tìm thấy sản phẩm trong kho.");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    // ── Cart ──────────────────────────────────────────────────────────────────

    public static void viewCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: filterMediaInCart();  break;
                case 2: sortMediaInCart();    break;
                case 3: removeMediaFromCart(); break;
                case 4: playMediaInCart();    break;
                case 5:
                    System.out.println("Đơn hàng đã được tạo. Giỏ hàng đã trống.");
                    cart.emptyCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0 && choice != 5);
    }

    public static void cartMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose: 0-1-2-3-4-5: ");
    }

    private static void filterMediaInCart() {
        System.out.println("1. Filter by ID | 2. Filter by Title");
        int sub = scanner.nextInt();
        scanner.nextLine();
        if (sub == 1) {
            System.out.print("Nhập ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            // Tìm kiếm thủ công thay vì gọi searchById()
            boolean found = false;
            for (Media m : cart.getItemsOrdered()) {
                if (m.getId() == id) {
                    System.out.println("Found: " + m.toString());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy item với ID = " + id);
            }
        } else {
            System.out.print("Nhập Title: ");
            String title = scanner.nextLine();
            // Tìm kiếm thủ công thay vì gọi searchByTitle()
            boolean found = false;
            for (Media m : cart.getItemsOrdered()) {
                if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    System.out.println("Found: " + m.toString());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy item với title \"" + title + "\"");
            }
        }
    }

    private static void sortMediaInCart() {
        System.out.println("1. Sort by Title then Cost | 2. Sort by Cost then Title");
        int sub = scanner.nextInt();
        scanner.nextLine();
        if (sub == 1) {
            cart.sortByTitleCost();
            System.out.println("Đã sắp xếp theo Title → Cost.");
        } else {
            cart.sortByCostTitle();
            System.out.println("Đã sắp xếp theo Cost → Title.");
        }
        cart.print();
    }

    private static void removeMediaFromCart() {
        System.out.print("Nhập tiêu đề muốn xóa: ");
        String title = scanner.nextLine();
        // Tìm trong ObservableList
        Media target = null;
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                target = m;
                break;
            }
        }
        if (target != null) {
            cart.removeMedia(target);
        } else {
            System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng.");
        }
    }

    private static void playMediaInCart() {
        System.out.print("Nhập tiêu đề muốn Play: ");
        String title = scanner.nextLine();
        // Tìm trong ObservableList
        Media target = null;
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                target = m;
                break;
            }
        }
        if (target != null) {
            if (target instanceof Playable) {
                try {
                    ((Playable) target).play();
                } catch (PlayerException e) {
                    System.err.println("Lỗi phát: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("Sản phẩm này không hỗ trợ Play (ví dụ: Sách).");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng.");
        }
    }
}