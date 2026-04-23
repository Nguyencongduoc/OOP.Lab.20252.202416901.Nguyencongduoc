package hust.soict.elitech.hedspi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "OtherProjects/hust/soict/elitech/hedspi/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            // GIẢI QUYẾT BẰNG StringBuffer
            StringBuffer outputStringBuffer = new StringBuffer();
            for (byte b : inputBytes) {
                outputStringBuffer.append((char) b);
            }
            String finalString = outputStringBuffer.toString();

            endTime = System.currentTimeMillis();
            System.out.println("NoGarbage tốn: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Không tìm thấy file " + filename);
            e.printStackTrace();
        }
    }
}