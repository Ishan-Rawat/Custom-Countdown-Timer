import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.color.*;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// abhi problem yeh hai ki JButton ko myFrame mai implement kar diya toh intTime ko modify kaise karunga. 
// Aur JButton is class mai implement ho nahi raha hai

public class Main {
	JButton upButton;
	static int intTime = 60;
	
	public static void main(String args[]) {
		myFrame frame = new myFrame();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(41,19,46));
		
		//creating the Countdown timer's time showing part's label:
		
		String stringTime= String.valueOf(intTime);
		
		JLabel time = new JLabel();
		time.setText(stringTime);
		time.setHorizontalTextPosition(JLabel.CENTER);
		time.setVerticalTextPosition(JLabel.CENTER);
		time.setFont(new Font("Helvetica", Font.PLAIN, 50));
		time.setForeground(new Color(222,0,42));
		
		//Creating the up and down buttons
		
		ImageIcon down = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\down.png");
		
		mainPanel.add(time);
		
		frame.add(mainPanel);
	}
}
