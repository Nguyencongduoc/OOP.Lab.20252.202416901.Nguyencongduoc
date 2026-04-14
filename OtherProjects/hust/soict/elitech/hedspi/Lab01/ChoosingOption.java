package hust.soict.elitech.hedspi.Lab01;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        Object[] options = {"Yes", "No"};
        int option = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}