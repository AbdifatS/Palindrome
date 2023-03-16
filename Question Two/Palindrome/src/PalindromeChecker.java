import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PalindromeChecker extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public PalindromeChecker() {
        // Set up the GUI components
        setTitle("Palindrome Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.addActionListener(new CheckPalindromeListener());

        JLabel promptLabel = new JLabel("Enter a number to check if it's a palindrome:");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));

        add(promptLabel);
        add(inputField);
        add(resultLabel);

        // Set up the window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CheckPalindromeListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Get the user input
            String inputStr = inputField.getText();
            int inputNum = Integer.parseInt(inputStr);

            // Check if the input number is a palindrome
            boolean isPalindrome = true;
            String reverseStr = "";
            for (int i = inputStr.length() - 1; i >= 0; i--) {
                reverseStr += inputStr.charAt(i);
            }
            int reverseNum = Integer.parseInt(reverseStr);
            if (inputNum != reverseNum) {
                isPalindrome = false;
            }

            // Display the result
            if (isPalindrome) {
                resultLabel.setText(inputNum + " is a palindrome!");
            } else {
                resultLabel.setText(inputNum + " is not a palindrome.");
            }
        }
    }

    public static void main(String[] args) {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
    }
}
