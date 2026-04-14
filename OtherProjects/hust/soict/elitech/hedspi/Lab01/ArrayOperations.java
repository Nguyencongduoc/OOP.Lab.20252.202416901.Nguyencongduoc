package hust.soict.elitech.hedspi.Lab01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int[] myArray = new int[n];

        // Nhập các phần tử
        System.out.println("Nhập các phần tử của mảng:");
        for(int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            myArray[i] = sc.nextInt();
        }

        Arrays.sort(myArray);

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }

        double average = (double) sum / myArray.length;

        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(myArray));
        System.out.println("Tổng các phần tử: " + sum);
        System.out.println("Giá trị trung bình: " + average);

        sc.close();
    }
}