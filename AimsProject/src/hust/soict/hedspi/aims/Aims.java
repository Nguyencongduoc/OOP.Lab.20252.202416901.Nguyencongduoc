package src.hust.soict.hedspi.aims;
import src.hust.soict.hedspi.aims.cart.Cart;
import src.hust.soict.hedspi.aims.store.Store;
import src.hust.soict.hedspi.aims.media.*;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu cho Store
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        Book book = new Book(2, "Java Programming", "Education", 25.0f);
        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 15.0f, "Director A", "Artist X");
        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: System.out.println("Tạm biệt!"); break;
                default: System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(); break;
                case 3: playMediaInStore(); break;
                case 4: viewCart(); break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
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
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                cart.addMedia(media);
            } else if (choice == 2 && media instanceof Playable) {
                ((Playable) media).play();
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
            ((Playable) media).play();
        } else {
            System.out.println("Sản phẩm này không thể chạy thử.");
        }
    }

    public static void updateStore() {
        System.out.println("Chức năng cập nhật kho (Add/Remove Media) - [Tự thực hiện]");
    }

    public static void viewCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: filterMediaInCart(); break;
                case 2: sortMediaInCart(); break;
                case 3: removeMediaFromCart(); break;
                case 4: playMediaInCart(); break;
                case 5:
                    System.out.println("Đơn hàng đã được tạo. Giỏ hàng đã trống.");
                    cart.emptyCart();
                    break;
                case 0: break;
            }
        } while (choice != 0 && choice != 5);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void filterMediaInCart() {
        System.out.println("1. Filter by ID | 2. Filter by Title");
        int sub = scanner.nextInt();
        scanner.nextLine();
        if (sub == 1) {
            System.out.print("Nhập ID: ");
            cart.searchById(scanner.nextInt());
        } else {
            System.out.print("Nhập Title: ");
            cart.searchByTitle(scanner.nextLine());
        }
    }

    private static void sortMediaInCart() {
        System.out.println("1. Sort by Title | 2. Sort by Cost");
        int sub = scanner.nextInt();
        if (sub == 1) cart.sortByTitleCost();
        else cart.sortByCostTitle();
        cart.print();
    }

    private static void removeMediaFromCart() {
        System.out.print("Nhập tiêu đề muốn xóa: ");
        String title = scanner.nextLine();
        // Logic tìm và xóa trong Cart
    }

    private static void playMediaInCart() {
        System.out.print("Nhập tiêu đề muốn Play: ");
        String title = scanner.nextLine();
        // Logic tìm và gọi play() trong Cart
    }
}
