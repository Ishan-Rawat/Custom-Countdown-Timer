import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.color.*;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// abhi problem yeh hai ki JButton ko myFrame mai implement kar diya toh intTime ko modify kaise karunga. 
// Aur JButton is class mai implement ho nahi raha hai
// Button ko seedhe frame mai add kara hai aur panel ko bhi, fir bhi somehow button panel ke upar aa raha hai.
// gotta get my shit together. lets create the frame and the panel and the label and the button in the same class now!.
public class Main {
	static int intTime = 60;
	
	public static void main(String args[]) {
		//---------------------------------FRAME----------------------
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Countdown timer");
		
		//---------------------------------MAIN PANEL-------------------
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(41,19,46));
		mainPanel.setLayout(null);
		
		//--------------------------------TIME LABEL---------------------
		/*
		String stringTime= String.valueOf(intTime);
		
		JLabel time = new JLabel();
		time.setText(stringTime);
		time.setHorizontalTextPosition(JLabel.CENTER);
		time.setVerticalTextPosition(JLabel.CENTER);
		time.setFont(new Font("Helvetica", Font.PLAIN, 50));
		time.setForeground(new Color(222,0,42));
		time.setBounds(120, 10, 200, 200);
		*/
		//---------------------------------BUTTONS------------------------
		upButtonAction button = new upButtonAction();
		//ImageIcon down = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\down.png");
		
		//---------------------------------FINAL ADDITIONS----------------
		mainPanel.add(button.time);
		mainPanel.add(button.upButton);
		frame.add(mainPanel);
		frame.setVisible(true); // you should put this line at the end or the components won't show up. and a whole bunch of issues. 
		//But now the setBounds method of upButton doesnt work. This can be fixed by setting panel.setLayout(null) 
		
	}
}
// Turns out, you dont really need ChangeListener class to update Time on screen 
class upButtonAction implements ActionListener{
	JButton upButton;
	JLabel time;
	String stringTime;
	public upButtonAction() {
		// The idea is to create a JButton with this constructor.
		upButton = new JButton();
		upButton.addActionListener(this);
		upButton.setFocusable(false);
		upButton.setBackground(new Color(50,20,80));
		upButton.setBounds(10, 10, 100, 50); // x, y, width, height
		
		ImageIcon up = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\up.png");
		upButton.setIcon(up);
		
		//---------------Label---------------
		time = new JLabel();
		stringTime= String.valueOf(Main.intTime);
		time.setText(stringTime);
		time.setHorizontalTextPosition(JLabel.CENTER);
		time.setVerticalTextPosition(JLabel.CENTER);
		time.setFont(new Font("Helvetica", Font.PLAIN, 50));
		time.setForeground(new Color(222,0,42));
		time.setBounds(120, 10, 200, 200);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==upButton) {
			//System.out.println("Button clicked!");
			Main.intTime++;
			time.setText(String.valueOf(Main.intTime));
			System.out.println(Main.intTime);
		}
	}
	
	/*
	public void stateChanged(ChangeEvent e) {
		Main.intTime++;
		time.setText(stringTime);
		//label.setFont(new Font("Helvitica", Font.PLAIN, 25));
		System.out.println(Main.intTime);
	}
	*/
}
