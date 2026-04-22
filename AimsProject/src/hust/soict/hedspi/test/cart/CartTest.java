package src.hust.soict.hedspi.test.cart;

import src.hust.soict.hedspi.aims.cart.Cart;
import src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
        cart.addDVD(dvd3);

        // 1. Test the print method
        cart.print();

        // 2. Test the search methods here
        System.out.println("\n--- Testing Search by ID ---");
        cart.searchById(1); // Nên tìm thấy "The Lion King" (vì là đĩa đầu tiên đc tạo)
        cart.searchById(5); // Nên in ra "No match found..."

        System.out.println("\n--- Testing Search by Title ---");
        cart.searchByTitle("Star Wars"); // Nên tìm thấy
        cart.searchByTitle("Aladin"); // Nên tìm thấy
        cart.searchByTitle("Harry Potter"); // Nên in ra "No match found..."
    }
}