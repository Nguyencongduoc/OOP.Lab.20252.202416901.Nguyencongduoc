package hust.soict.elitech.hedspi;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // 1. Dùng toán tử '+' với String
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Thời gian dùng toán tử '+': " + (System.currentTimeMillis() - start) + " ms");

        // Dùng StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Thời gian dùng StringBuilder: " + (System.currentTimeMillis() - start) + " ms");

        // Dùng StringBuffer (Tuỳ chọn thêm để so sánh)
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sBuffer.append(r.nextInt(2));
        }
        s = sBuffer.toString();
        System.out.println("Thời gian dùng StringBuffer: " + (System.currentTimeMillis() - start) + " ms");
    }
}