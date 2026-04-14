import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số hàng của ma trận: ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = sc.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        System.out.println("\nNhập các phần tử cho MA TRẬN 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Nhập phần tử ở hàng " + (i+1) + " cột " + (j+1) + ": ");
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nNhập các phần tử cho MA TRẬN 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Nhập phần tử ở hàng " + (i+1) + " cột " + (j+1) + ": ");
                matrix2[i][j] = sc.nextInt();
            }
        }

        System.out.println("\n--- KẾT QUẢ: TỔNG 2 MA TRẬN ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(sumMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}