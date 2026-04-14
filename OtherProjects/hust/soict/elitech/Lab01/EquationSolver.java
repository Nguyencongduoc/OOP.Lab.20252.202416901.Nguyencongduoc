import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn chức năng:");
        System.out.println("1. Giải phương trình bậc nhất (ax + b = 0)");
        System.out.println("2. Giải hệ phương trình bậc nhất 2 ẩn");
        System.out.println("3. Giải phương trình bậc hai (ax^2 + bx + c = 0)");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Nhập a: "); double a = sc.nextDouble();
            System.out.print("Nhập b: "); double b = sc.nextDouble();
            if (a == 0) {
                if (b == 0) System.out.println("Phương trình vô số nghiệm.");
                else System.out.println("Phương trình vô nghiệm.");
            }
            else {
                System.out.println("Nghiệm x = " + (-b / a));
            }
        }
        else if (choice == 2) {
            System.out.print("Nhập a11, a12, b1: ");
            double a11 = sc.nextDouble(), a12 = sc.nextDouble(), b1 = sc.nextDouble();
            System.out.print("Nhập a21, a22, b2: ");
            double a21 = sc.nextDouble(), a22 = sc.nextDouble(), b2 = sc.nextDouble();

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if (D == 0) {
                if (D1 == 0 && D2 == 0) System.out.println("Hệ phương trình vô số nghiệm.");
                else System.out.println("Hệ phương trình vô nghiệm.");
            }
            else {
                System.out.println("x1 = " + (D1 / D) + ", x2 = " + (D2 / D));
            }
        }
        else if (choice == 3) {
            System.out.print("Nhập a, b, c: ");
            double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
            if (a == 0) {
                System.out.println("Trở thành phương trình bậc nhất bx + c = 0");
            }
            else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    System.out.println("Phương trình vô nghiệm.");
                }
                else if (delta == 0) {
                    System.out.println("Phương trình có nghiệm kép x = " + (-b / (2 * a)));
                }
                else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("x1 = " + x1 + ", x2 = " + x2);
                }
            }
        }
        sc.close();
    }
}