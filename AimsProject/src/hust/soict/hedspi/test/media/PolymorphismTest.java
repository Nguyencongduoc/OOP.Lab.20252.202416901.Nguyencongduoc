package src.hust.soict.hedspi.test.media;


import src.hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        // Tạo danh sách kiểu Media (Lớp cha) [cite: 1301]
        List<Media> mediae = new ArrayList<Media>();

        // Thêm các đối tượng lớp con khác nhau [cite: 1302-1307]
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        Book book = new Book(2, "Java Programming", "Education", 25.0f);
        book.addAuthor("James Gosling");

        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 15.0f, "Director A", "Artist X");
        cd.addTrack(new Track("Track 1", 3));
        cd.addTrack(new Track("Track 2", 4));

        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

        // Duyệt danh sách và in thông tin [cite: 1309-1310]
        System.out.println("\n--- Polymorphism toString() Test ---");
        for (Media m : mediae) {
            // Tính Đa hình: Java tự gọi toString() tương ứng của DVD, Book hoặc CD
            System.out.println(m.toString());
        }
    }
}