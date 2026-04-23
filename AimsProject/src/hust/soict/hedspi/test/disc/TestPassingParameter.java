package src.hust.soict.hedspi.test.disc;

import src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
public class TestPassingParameter {
    public static void main(String[] args) {
        // CẬP NHẬT: Thêm các tham số giả (dummy data) cho đủ 6 tham số
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc(1, "Jungle", "Animation", 15.5f, 90, "Unknown");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc(2, "Cinderella", "Animation", 20.0f, 85, "Unknown");

        System.out.println("Before swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);

        System.out.println("After swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("After changeTitle:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        // CẬP NHẬT: Thêm tham số cho lệnh new ở đây nữa
        dvd = new DigitalVideoDisc(3, oldTitle, "Unknown", 0.0f, 0, "Unknown");
    }
}