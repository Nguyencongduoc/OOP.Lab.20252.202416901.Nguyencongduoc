package src.hust.soict.hedspi.test.store;

import src.hust.soict.hedspi.aims.store.Store;
import src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class StoreTest {
    public static void main(String[] args) {
        // Tạo một cửa hàng mới
        Store store = new Store();

        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);

        // 1. Test chức năng thêm (add)
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // In ra kho để kiểm tra
        store.printStore();

        // 2. Test chức năng xóa (remove)
        System.out.println("\n-- Tiến hành xóa đĩa Star Wars --");
        store.removeDVD(dvd2);

        // In lại kho để kiểm tra xem đã mất Star Wars chưa
        store.printStore();

        // 3. Test trường hợp xóa đĩa không tồn tại
        System.out.println("\n-- Tiến hành xóa lại đĩa Star Wars --");
        store.removeDVD(dvd2); // Đĩa này vừa bị xóa rồi nên sẽ báo không tìm thấy
    }
}