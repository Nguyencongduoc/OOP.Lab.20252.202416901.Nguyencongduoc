package hust.soict.hedspi.test.screen.customer.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Đường dẫn trỏ tới Cart.fxml
        final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

        // Truyền cả store và cart vào controller theo yêu cầu phần 7 [cite: 1608]
        CartController cartController = new CartController(store, cart);
        fxmlLoader.setController(cartController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        // Thêm một vài Media trực tiếp vào Cart để test hiển thị của TableView
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker");

        try {
            cart.addMedia(dvd1);
            cart.addMedia(dvd2);
            cart.addMedia(dvd3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        launch(args);
    }
}