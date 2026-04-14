import javax.swing.JOptionPane;

public class Cal2Num {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Nhập số thứ nhất:");
        String strNum2 = JOptionPane.showInputDialog("Nhập số thứ hai:");

        double num1 = Double.parseDouble(strNum1); // string to double
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double diff = Math.abs(num1 - num2); // Hoặc num1 - num2
        double prod = num1 * num2;

        String quot = (num2 != 0) ? String.valueOf(num1 / num2) : "Không thể chia cho 0";

        String result = "Tổng: " + sum + "\nHiệu: " + diff +
                "\nTích: " + prod + "\nThương: " + quot;

        JOptionPane.showMessageDialog(null, result, "Kết quả tính toán", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}