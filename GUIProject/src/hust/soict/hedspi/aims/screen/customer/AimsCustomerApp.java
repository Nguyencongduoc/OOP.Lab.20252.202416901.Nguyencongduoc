package hust.soict.hedspi.aims.screen.customer;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AimsCustomerApp extends Application {

    // Dùng static để truyền dữ liệu từ main() vào start()
    private static Store store = new Store();
    private static Cart  cart  = new Cart();

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_PATH =
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(STORE_FXML_PATH));

        // Đặt controller thủ công vì constructor có tham số
        ViewStoreController controller = new ViewStoreController(store, cart);
        loader.setController(controller);

        Parent root = loader.load();

        primaryStage.setTitle("AIMS - Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // ── Thêm dữ liệu mẫu vào Store ──────────────────────────────────────

        // DVD 1 - có thể play (length > 0)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                1, "Harry Potter and the Philosopher's Stone (2001)",
                "Fantasy", 3.0f, 152, "Chris Columbus");

        // DVD 2 - có thể play
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                2, "Harry Potter and the Chamber of Secrets (2002)",
                "Fantasy", 3.5f, 161, "Chris Columbus");

        // DVD 3 - KHÔNG thể play (length = 0) → test PlayerException
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                3, "Broken DVD - Test PlayerException",
                "Test", 1.0f, 0, "Unknown");

        // CD với tracks
        CompactDisc cd1 = new CompactDisc(
                4, "Abbey Road", "Music", 5.0f, "George Martin", "The Beatles");
        cd1.addTrack(new Track("Come Together", 259));
        cd1.addTrack(new Track("Something", 182));
        cd1.addTrack(new Track("Here Comes the Sun", 185));

        // CD với track lỗi → test PlayerException trong track
        CompactDisc cd2 = new CompactDisc(
                5, "CD With Bad Track", "Music", 4.0f, "Producer", "Artist");
        cd2.addTrack(new Track("Good Track",  200));
        cd2.addTrack(new Track("Bad Track",     0)); // length = 0 → exception

        // Book (không implement Playable → nút Play ẩn)
        // Nếu bạn có class Book:
        // Book book1 = new Book(6, "Green Eggs and Ham", "Children", 3.3f, "Dr. Seuss");
        // store.addMedia(book1);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);

        // ── Thêm sẵn 1 item vào Cart để test màn hình Cart ──────────────────
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);

        // ── Khởi chạy JavaFX ─────────────────────────────────────────────────
        launch(args);
    }
}