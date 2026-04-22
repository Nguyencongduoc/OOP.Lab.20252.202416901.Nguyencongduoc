package src.hust.soict.hedspi.aims.cart;

import src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Cart {
    private int qtyOrdered = 0;
    private final int maxItem = 20;
    private DigitalVideoDisc[] items = new DigitalVideoDisc[maxItem];

    // Thêm 1 đĩa
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered < maxItem) {
            items[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("The disc '" + dvd.getTitle() + "' has been added.");
        } else {
            System.out.println("The cart is almost full. Cannot add '" + dvd.getTitle() + "'.");
        }
    }

    // Thêm mảng đĩa
    public void addDVD(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDVD(dvd);
        }
    }

    // Thêm 2 đĩa
    public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDVD(dvd1);
        addDVD(dvd2);
    }

    // Xóa đĩa
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i] == dvd) {
                // Dịch các phần tử sang trái để lấp chỗ trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[qtyOrdered - 1] = null; // Xóa phần tử cuối
                qtyOrdered--;
                found = true;
                System.out.println("The disc '" + dvd.getTitle() + "' has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart.");
        }
    }

    // Tính tổng tiền
    public double calculateTotalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += items[i].getCost();
        }
        return Math.round(total * 100.0) / 100.0; // Làm tròn 2 chữ số thập phân
    }

    // ---------------------------------------------------------
    // CÁC PHƯƠNG THỨC MỚI YÊU CẦU TRONG SECTION 4 LAB 03
    // ---------------------------------------------------------

    // Phương thức in danh sách giỏ hàng theo format
    public void print() {
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            // Sử dụng hàm toString() của DigitalVideoDisc nếu có, nếu không in thủ công
            System.out.println((i + 1) + ". DVD - " + items[i].getTitle() + " - "
                    + items[i].getCategory() + " - " + items[i].getDirector() + " - "
                    + items[i].getLength() + ": " + items[i].getCost() + " $");
        }
        System.out.println("Total cost: " + calculateTotalCost() + " $");
    }
    // Tìm kiếm theo ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i].getId() == id) {
                System.out.println("Found: DVD - " + items[i].getTitle() + " - " + items[i].getCategory() + " - " + items[i].getCost() + " $");
                found = true;
                break; // ID là duy nhất nên tìm thấy thì thoát vòng lặp
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Tìm kiếm theo Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: DVD - " + items[i].getTitle() + " - " + items[i].getCategory() + " - " + items[i].getCost() + " $");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for Title: " + title);
        }
    }
}