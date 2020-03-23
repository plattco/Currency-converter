import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CurrencyConversion extends JFrame {

	JLabel amount = new JLabel("Enter Amount: ");
	//JTextField amountTextField = new JTextField(40);
	//amountTextField.  //setPreferredSize(new Dimension(350, 20));
	JPanel panel = new JPanel();
	JButton but = new JButton();

	JTextArea amountTextField = new JTextArea();
	JTextArea resultTextField = new JTextArea();

	JButton convertButton = new JButton("Convert");
	JComboBox currency1 = new JComboBox();
	JComboBox currency2 = new JComboBox();

	double inputAmount;
	double resultAmount;

	JLabel result = new JLabel("Result: ");

	public CurrencyConversion() {
		setSize(300, 300);
		setTitle("Font Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createCurrencies();

		amountTextField.setPreferredSize(new Dimension(250, 20));
		resultTextField.setPreferredSize(new Dimension(250, 20));

		panel.add(convertButton);
		panel.add(amountTextField);
		panel.add(currency1);
		panel.add(currency2);
		panel.add(result);
		panel.add(resultTextField);

		convertButton.addActionListener(new ConversionActionListener());

		add(panel);
		setVisible(true);
	}

	class ConversionActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cur1 = (String)currency1.getSelectedItem();
			String cur2 = (String)currency2.getSelectedItem();

			inputAmount = Double.parseDouble(amountTextField.getText());

			if(cur1.equals("USD") && cur2.equals("EUR"))
			{
				resultAmount = inputAmount*.85;
			}
			if(cur1.equals("USD") && cur2.equals("GBP"))
			{
				resultAmount = inputAmount*.76;
			}
			if(cur1.equals("EUR") && cur2.equals("USD"))
			{
				resultAmount = inputAmount*1.17;
			}
			if(cur1.equals("EUR") && cur2.equals("GBP"))
			{
				resultAmount = inputAmount*.89;
			}
			if(cur1.equals("GBP") && cur2.equals("USD"))
			{
				resultAmount = inputAmount*1.32;
			}
			if(cur1.equals("GBP") && cur2.equals("EUR"))
			{
				resultAmount = inputAmount*1.17;
			}
			if(cur1.equals(cur2))
			{
				String inputAmountAsString = String.valueOf(inputAmount);
				JOptionPane.showMessageDialog(but, "The Currencies are the same, Change them");
			}
			else
			{
				String resultAmountAsString = String.valueOf(resultAmount);
				resultTextField.setText(resultAmountAsString);
			}
		}
	}

	void createCurrencies() {
		currency1.addItem("USD");
		currency1.addItem("EUR");
		currency1.addItem("GBP");

		currency2.addItem("USD");
		currency2.addItem("EUR");
		currency2.addItem("GBP");
	}

	public static void main(String args[]) {
		CurrencyConversion cc = new CurrencyConversion();
	}
}
