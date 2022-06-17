import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.color.*;
import java.awt.Font;

public class Main {
	public static void main(String args[]) {
		myFrame frame = new myFrame();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(41,19,46));
		
		//creating the Countdown timer's time showing part's label:
		int intTime = 60;
		String stringTime= String.valueOf(intTime);
		
		JLabel time = new JLabel();
		time.setText(stringTime);
		time.setHorizontalTextPosition(JLabel.CENTER);
		time.setVerticalTextPosition(JLabel.CENTER);
		time.setFont(new Font("Helvetica", Font.PLAIN, 50));
		time.setForeground(new Color(222,0,42));
		
		mainPanel.add(time);
		
		frame.add(mainPanel);
	}
}
