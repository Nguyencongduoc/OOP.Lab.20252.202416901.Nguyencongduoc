import java.util.Scanner;
import java.util.Arrays;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = -1;
        int month = -1;

        // Các mảng chứa các định dạng hợp lệ của tháng
        String[] jan = {"january", "jan.", "jan", "1"};
        String[] feb = {"february", "feb.", "feb", "2"};
        String[] mar = {"march", "mar.", "mar", "3"};
        String[] apr = {"april", "apr.", "apr", "4"};
        String[] may = {"may", "5"};
        String[] jun = {"june", "jun", "6"};
        String[] jul = {"july", "jul", "7"};
        String[] aug = {"august", "aug.", "aug", "8"};
        String[] sep = {"september", "sept.", "sep", "9"};
        String[] oct = {"october", "oct.", "oct", "10"};
        String[] nov = {"november", "nov.", "nov", "11"};
        String[] dec = {"december", "dec.", "dec", "12"};

        while (true) {
            System.out.print("Nhập tháng (Tên đầy đủ, viết tắt, 3 chữ cái hoặc số): ");
            String monthInput = sc.next().toLowerCase();

            if (Arrays.asList(jan).contains(monthInput)) month = 1;
            else if (Arrays.asList(feb).contains(monthInput)) month = 2;
            else if (Arrays.asList(mar).contains(monthInput)) month = 3;
            else if (Arrays.asList(apr).contains(monthInput)) month = 4;
            else if (Arrays.asList(may).contains(monthInput)) month = 5;
            else if (Arrays.asList(jun).contains(monthInput)) month = 6;
            else if (Arrays.asList(jul).contains(monthInput)) month = 7;
            else if (Arrays.asList(aug).contains(monthInput)) month = 8;
            else if (Arrays.asList(sep).contains(monthInput)) month = 9;
            else if (Arrays.asList(oct).contains(monthInput)) month = 10;
            else if (Arrays.asList(nov).contains(monthInput)) month = 11;
            else if (Arrays.asList(dec).contains(monthInput)) month = 12;

            System.out.print("Nhập năm (VD: 1999): ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
            } else {
                sc.next(); // bỏ qua input sai
            }

            if (month != -1 && year >= 0) break;
            System.out.println("Tháng hoặc năm không hợp lệ. Vui lòng nhập lại!\n");
        }

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31; break;
            case 4: case 6: case 9: case 11:
                days = 30; break;
            case 2:
                days = isLeapYear ? 29 : 28; break;
        }

        System.out.println("Tháng " + month + " năm " + year + " có " + days + " ngày.");
        sc.close();
    }
}