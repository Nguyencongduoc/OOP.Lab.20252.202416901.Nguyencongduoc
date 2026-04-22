package src.hust.soict.hedspi.aims.store;


// Import lớp DigitalVideoDisc từ package disc (theo cấu trúc hiện tại của bạn)
import src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    // Thuộc tính mảng lưu trữ các DVD trong cửa hàng
    private DigitalVideoDisc[] itemsInStore;
    private int qtyInStore = 0;
    private static final int MAX_ITEMS_IN_STORE = 1000; // Giới hạn số lượng đĩa trong kho

    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    }

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Đã thêm đĩa '" + dvd.getTitle() + "' vào kho của cửa hàng.");
        } else {
            System.out.println("Kho của cửa hàng đã đầy! Không thể thêm '" + dvd.getTitle() + "'.");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) { // So sánh tham chiếu (sẽ học ghi đè equals sau)
                // Dịch chuyển các phần tử phía sau lên 1 vị trí để lấp khoảng trống
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Xóa tham chiếu ở vị trí cuối
                qtyInStore--;
                found = true;
                System.out.println("Đã xóa đĩa '" + dvd.getTitle() + "' khỏi kho của cửa hàng.");
                break; // Xóa xong thì thoát vòng lặp
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy đĩa '" + dvd.getTitle() + "' trong kho!");
        }
    }

    // Phương thức hỗ trợ hiển thị kho
    public void printStore() {
        System.out.println("--- STORE INVENTORY ---");
        if (qtyInStore == 0) {
            System.out.println("Kho đang trống.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("-----------------------");
    }
}