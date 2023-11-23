package calculator.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private JButton clearEntryButton;

    public CalculatorView() {
        initializeUI();
    }

    private void initializeUI() {
        // Set up the frame
        setTitle("Kalkulator Wahid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(7, 3));  // Changed to 3 x 7

        // Add number buttons (1-9)
        numberButtons = new JButton[10];
        for (int i = 1; i <= 9; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            buttonPanel.add(numberButtons[i]);
        }

        // Add operator buttons
        operatorButtons = new JButton[]{
                new JButton("+"),
                new JButton("-"),
                new JButton("*"),
                new JButton("/")
        };

        // Add special buttons
        buttonPanel.add(clearEntryButton = new JButton("CE"));  // CE
		// Initialize numberButtons[0] separately
        numberButtons[0] = new JButton("0");
        buttonPanel.add(numberButtons[0]);  // 0
        buttonPanel.add(clearButton = new JButton("C"));       // C
        

        buttonPanel.add(operatorButtons[0]);  // Addition (+)
        buttonPanel.add(operatorButtons[1]);  // Subtraction (-)
		buttonPanel.add(equalsButton = new JButton("="));      // =
        buttonPanel.add(operatorButtons[2]);  // Multiplication (*)
        buttonPanel.add(operatorButtons[3]);  // Division (/)

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public void setTextField(String text) {
        textField.setText(text);
    }

    public String getTextField() {
        return textField.getText();
    }

    public void addNumberButtonListener(ActionListener listener) {
        for (JButton button : numberButtons) {
            button.addActionListener(listener);
        }
    }

    public void addOperatorButtonListener(ActionListener listener) {
        for (JButton button : operatorButtons) {
            button.addActionListener(listener);
        }
    }

    public void addEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public void addClearEntryButtonListener(ActionListener listener) {
        clearEntryButton.addActionListener(listener);
    }
}
