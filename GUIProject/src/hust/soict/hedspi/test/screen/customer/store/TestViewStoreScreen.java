package hust.soict.hedspi.test.screen.customer.store;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Đường dẫn tới file FXML. Đảm bảo file FXML của bạn nằm đúng thư mục này[cite: 1183].
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        // Cập nhật: Truyền cả store và cart vào controller theo yêu cầu phần 7 của Lab 05 [cite: 1607]
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        // Tạo một vài sản phẩm mẫu để test hiển thị [cite: 1193]
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Matrix", "Action", 20.00f, 136, "The Wachowskis");

        try {
            store.addMedia(dvd1);
            store.addMedia(dvd2);
            store.addMedia(dvd3);
            store.addMedia(dvd4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        launch(args);
    }
}