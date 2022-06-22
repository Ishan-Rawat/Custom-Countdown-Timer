import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.color.*;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

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
		mainPanel.setLayout(new GridLayout(2,4));
		
		//---------------------------------FILLER PANELS------------------
		JLabel label1 = new JLabel();
		JLabel label4 = new JLabel();
		//JLabel label5 = new JLabel();
		
		//---------------------------------BUTTONS------------------------
		ButtonAction button = new ButtonAction();
		
		//---------------------------------FINAL ADDITIONS----------------
		mainPanel.add(label1);
		mainPanel.add(button.timeMinutes);
		mainPanel.add(button.time);
		mainPanel.add(label4);
		mainPanel.add(button.upButton);
		mainPanel.add(button.startButton);
		mainPanel.add(button.stopButton);
		mainPanel.add(button.downButton);
		frame.add(mainPanel);
		frame.setVisible(true); // you should put this line at the end or the components won't show up. and a whole bunch of issues. 
		//But now the setBounds method of upButton doesnt work. This can be fixed by setting panel.setLayout(null) 
		
	}
}
// Turns out, you dont really need ChangeListener class to update Time on screen 
class ButtonAction implements ActionListener{
	JButton upButton;
	JButton downButton;
	JButton startButton;
	JButton stopButton;
	JLabel time;
	JLabel timeMinutes;
	String stringTime;
	String stringTimeMinutes;
	//----------------Timer and Timer Task--------------
	Timer timer = new Timer();
	
	TimerTask task = new TimerTask() {
		//int counter = 10;
		public void run() {
			if(Main.intTime>0) {
				System.out.println(Main.intTime+ " seconds");
				Main.intTime--;
				time.setText(String.valueOf(Main.intTime));
				timeMinutes.setText(String.valueOf(Main.intTime/60));
				if(Main.intTime<=60 && Main.intTime>15) {
					time.setForeground(new Color(222,0,42));
					timeMinutes.setForeground(new Color(222,0,42));
				}
				else {
					time.setForeground(new Color(66,135,245));
					timeMinutes.setForeground(new Color(66,135,245));
				}
			}
			else {
				timer.cancel();
			}
		}
	};
	
	public ButtonAction() {
		// The idea is to create a JButton with this constructor.
		//-------------------------Up Button-------------------------------------
		upButton = new JButton();
		upButton.addActionListener(this);
		upButton.setFocusable(false);
		upButton.setBackground(new Color(50,20,80));
		//upButton.setBounds(10, 10, 100, 50); // x, y, width, height
		ImageIcon up = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\up_smol.png");
		upButton.setIcon(up);
		
		//-------------------------Down Button------------------------------------
		downButton= new JButton();
		downButton.addActionListener(this);
		downButton.setFocusable(false);
		downButton.setBackground(new Color(50,20,80));
		//downButton.setBounds(10, 70, 100, 50);
		ImageIcon down = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\down_25.png");
		downButton.setIcon(down);
		
		//------------------------Start Button--------------------------------------
		startButton = new JButton();
		startButton.addActionListener(this);
		startButton.setFocusable(false);
		startButton.setText("Start");
		startButton.setBackground(new Color(50,20,80));
		startButton.setFont(new Font("Helvetica", Font.BOLD, 25));
		startButton.setForeground(Color.cyan);
		
		//------------------------Stop Button---------------------------------------
		stopButton = new JButton();
		stopButton.addActionListener(this);
		stopButton.setFocusable(false);
		stopButton.setText("Stop");
		stopButton.setBackground(new Color(50,20,80));
		stopButton.setFont(new Font("Helvetica", Font.BOLD, 25));
		stopButton.setForeground(Color.cyan);
		
		//---------------Time Label Seconds---------------
		stringTime= String.valueOf(Main.intTime);
		time = new JLabel(stringTime,SwingConstants.CENTER);
		time.setFont(new Font("Helvetica", Font.PLAIN, 50));
		time.setForeground(new Color(222,0,42));
		
		//----------------Time Label Minutes--------------
		stringTimeMinutes = String.valueOf(Main.intTime/60);
		timeMinutes = new JLabel(stringTimeMinutes, SwingConstants.CENTER);
		timeMinutes.setFont(new Font("Helvetica", Font.PLAIN, 50));
		timeMinutes.setForeground(new Color(222,0,42));
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==upButton) {
			//System.out.println("Button clicked!");
			Main.intTime++;
			time.setText(String.valueOf(Main.intTime));
			timeMinutes.setText(String.valueOf(Main.intTime/60));
			
		}
		else if(e.getSource()==downButton) {
			Main.intTime--;
			time.setText(String.valueOf(Main.intTime));
			timeMinutes.setText(String.valueOf(Main.intTime/60));
		}
		else if(e.getSource()==startButton) {
			timer.schedule(task, 0, 1000);
		}
		else if(e.getSource()==stopButton) {
			timer.cancel();
		}
	}
	
}
