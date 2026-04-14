package hust.soict.elitech.hedspi.Lab01;

import javax.swing.JOptionPane;
public class ShowTwoNumbers{
    public static void main(String[] args){
        String str1, str2;
        String strNotifications = "You've just entered: ";
        str1 = JOptionPane.showInputDialog(null, "Please enter your first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotifications += str1 + " and ";
        str2 = JOptionPane.showInputDialog(null, "Please er your second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotifications += str2;
        JOptionPane.showMessageDialog(null, strNotifications, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}