import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnPlayAgain;
	private int theNumber;
	private int tries;
	String game = "on";
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {	
			tries = tries + 1;
			int guess = Integer.parseInt(guessText);
	        if (guess < theNumber) {
	            message = guess + " is too low. Try again."; }
	        else if (guess > theNumber) {
	            message = guess + " is too high. Try again."; }
	        else {
	            message = guess + " is correct. You won in " + tries + " tries!";
	        	btnPlayAgain.setVisible(true);
	        }
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100";
		} finally {
	        lblOutput.setText(message);
	        txtGuess.setText("");
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		System.out.println(theNumber);
		lblOutput.setText("Take a guess");
		btnPlayAgain.setVisible(false);
		tries = 0;
	}
	public GuessingGame() {
		getContentPane().setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		JLabel lblRekteroniAndCheese = new JLabel("Guess Zidgel's Number: GOTY Edition");
		lblRekteroniAndCheese.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRekteroniAndCheese.setHorizontalAlignment(SwingConstants.CENTER);
		lblRekteroniAndCheese.setBounds(0, 0, 434, 17);
		getContentPane().add(lblRekteroniAndCheese);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100!");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessANumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuessANumber.setBounds(0, 60, 434, 14);
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGuess.setBounds(198, 100, 40, 23);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnSubmit.setToolTipText("");
		btnSubmit.setBounds(174, 156, 89, 23);
		getContentPane().add(btnSubmit);
		
		lblOutput = new JLabel("Enter a number and click submit.");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 190, 434, 14);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnPlayAgain.setBounds(174, 227, 89, 23);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Guessing Game");
		
	}

	
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
	}
	
	
}
