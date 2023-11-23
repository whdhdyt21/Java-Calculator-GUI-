package calculator.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // Attach listeners
        view.addNumberButtonListener(new NumberButtonListener());
        view.addOperatorButtonListener(new OperatorButtonListener());
        view.addEqualsButtonListener(new EqualsButtonListener());
        view.addClearButtonListener(new ClearButtonListener());
		view.addClearEntryButtonListener(new ClearEntryButtonListener());
    }

    class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getTextField();
            JButton sourceButton = (JButton) e.getSource();
            view.setTextField(currentText + sourceButton.getText());
        }
    }

    class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getTextField();
            JButton sourceButton = (JButton) e.getSource();
            view.setTextField(currentText + " " + sourceButton.getText() + " ");
        }
    }

    class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = view.getTextField();
            String[] parts = expression.split(" ");

            if (parts.length == 3) {
                double firstNumber = Double.parseDouble(parts[0]);
                char operator = parts[1].charAt(0);
                double secondNumber = Double.parseDouble(parts[2]);

                model.setFirstNumber(firstNumber);
                model.setOperator(operator);
                model.setSecondNumber(secondNumber);
                model.calculate();

                view.setTextField(Double.toString(model.getResult()));
            }
        }
    }

    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setTextField("");
        }
    }

	//kelas ini untuk menghapus satu karakter terakhir
	class ClearEntryButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String currentText = view.getTextField();
			if (currentText.length() > 0) {
				view.setTextField(currentText.substring(0, currentText.length() - 1));
			}
		}
	}
}
