package src.hust.soict.hedspi.test.cart;

import src.hust.soict.hedspi.aims.cart.Cart;
import src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // CẬP NHẬT 1: Thêm id (1, 2, 3) vào đầu và xếp lại thứ tự tham số
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f, 90, "John Musker");

        // CẬP NHẬT 2: Đổi addDVD thành addMedia
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // 1. Test the print method
        System.out.println("--- Test the print method ---");
        cart.print(); // Đảm bảo trong Cart.java bạn viết là print() hoặc displayCart() thì gọi cho đúng nhé

        // 2. Test the search methods
        System.out.println("\n--- Testing Search by ID ---");
        cart.searchById(1); // Nên tìm thấy "The Lion King"

        System.out.println("\n--- Testing Search by Title ---");
        cart.searchByTitle("Star Wars"); // Nên tìm thấy
    }
}