package hust.soict.elitech.hedspi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "OtherProjects/hust/soict/elitech/hedspi/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            // TẠO RÁC BỘ NHỚ bằng toán tử '+'
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }

            endTime = System.currentTimeMillis();
            System.out.println("GarbageCreator tốn: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Không tìm thấy file " + filename);
            e.printStackTrace();
        }
    }
}