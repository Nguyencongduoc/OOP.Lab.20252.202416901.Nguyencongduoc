package hust.soict.hedspi.aims.exception;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class TestPlayerException {

    public static void main(String[] args) {

        System.out.println("========== TEST 1: DVD hợp lệ (length > 0) ==========");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                1, "Avatar", "Sci-Fi", 5.0f, 162, "James Cameron");
        try {
            dvd1.play();
            System.out.println("PASS: DVD played successfully.\n");
        } catch (PlayerException e) {
            System.err.println("FAIL: " + e.getMessage() + "\n");
        }

        System.out.println("========== TEST 2: DVD không hợp lệ (length = 0) ==========");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                2, "Broken DVD", "Test", 1.0f, 0, "Unknown");
        try {
            dvd2.play();
            System.out.println("FAIL: Phải throw exception nhưng không throw.\n");
        } catch (PlayerException e) {
            System.out.println("PASS: Caught PlayerException: " + e.getMessage());
            System.out.println("      toString()         : " + e);
            System.out.println("      getMessage()       : " + e.getMessage());
            e.printStackTrace();
            System.out.println();
        }

        System.out.println("========== TEST 3: Track hợp lệ ==========");
        Track t1 = new Track("Good Song", 200);
        try {
            t1.play();
            System.out.println("PASS: Track played successfully.\n");
        } catch (PlayerException e) {
            System.err.println("FAIL: " + e.getMessage() + "\n");
        }

        System.out.println("========== TEST 4: Track không hợp lệ (length = 0) ==========");
        Track t2 = new Track("Silent Track", 0);
        try {
            t2.play();
            System.out.println("FAIL: Phải throw exception nhưng không throw.\n");
        } catch (PlayerException e) {
            System.out.println("PASS: Caught PlayerException: " + e.getMessage() + "\n");
        }

        System.out.println("========== TEST 5: CD hợp lệ (tất cả track OK) ==========");
        CompactDisc cd1 = new CompactDisc(
                3, "Abbey Road", "Music", 5.0f, "George Martin", "The Beatles");
        cd1.addTrack(new Track("Come Together", 259));
        cd1.addTrack(new Track("Something",     182));
        try {
            cd1.play();
            System.out.println("PASS: CD played successfully.\n");
        } catch (PlayerException e) {
            System.err.println("FAIL: " + e.getMessage() + "\n");
        }

        System.out.println("========== TEST 6: CD có track lỗi ==========");
        CompactDisc cd2 = new CompactDisc(
                4, "Bad CD", "Music", 3.0f, "Producer", "Artist");
        cd2.addTrack(new Track("Good Track", 180));
        cd2.addTrack(new Track("Bad Track",    0)); // sẽ throw exception
        try {
            cd2.play();
            System.out.println("FAIL: Phải throw exception nhưng không throw.\n");
        } catch (PlayerException e) {
            System.out.println("PASS: Caught PlayerException from CD: "
                    + e.getMessage() + "\n");
        }

        System.out.println("========== TEST 7: equals() và compareTo() ==========");
        DigitalVideoDisc a = new DigitalVideoDisc(
                10, "Inception", "Sci-Fi", 4.5f, 148, "Christopher Nolan");
        DigitalVideoDisc b = new DigitalVideoDisc(
                99, "Inception", "Action", 4.5f, 200, "Someone Else");
        DigitalVideoDisc c = new DigitalVideoDisc(
                11, "Inception", "Sci-Fi", 9.9f, 148, "Christopher Nolan");

        System.out.println("a.equals(b) [same title+cost]     → expect true  : " + a.equals(b));
        System.out.println("a.equals(c) [same title, diff cost]→ expect false : " + a.equals(c));
        System.out.println("a.compareTo(c) [a cheaper]         → expect < 0  : " + a.compareTo(c));
        System.out.println("c.compareTo(a) [c more expensive]  → expect > 0  : " + c.compareTo(a));
        System.out.println("a.compareTo(b) [identical]         → expect 0    : " + a.compareTo(b));
    }
}