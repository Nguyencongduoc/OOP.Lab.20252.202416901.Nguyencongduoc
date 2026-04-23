package src.hust.soict.hedspi.test.store;

import src.hust.soict.hedspi.aims.store.Store;
import src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
public class StoreTest {
    public static void main(String[] args) {
        // Tạo một cửa hàng mới
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f, 90, "John Musker");

        System.out.println("1. Test chức năng thêm (add)");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // In ra kho để kiểm tra (Đảm bảo file Store.java của bạn có hàm displayStore hoặc printStore)
        store.displayStore(); // Nếu bên Store.java bạn viết là printStore() thì sửa lại dòng này nhé

        // Test chức năng xóa (remove)
        System.out.println("\n-- Tiến hành xóa đĩa Star Wars --");
        store.removeMedia(dvd2); // Đổi removeDVD thành removeMedia

        // In lại kho để kiểm tra xem đã mất Star Wars chưa
        store.displayStore();

        // Test trường hợp xóa đĩa không tồn tại
        System.out.println("\n-- Tiến hành xóa lại đĩa Star Wars --");
        store.removeMedia(dvd2);
    }
}