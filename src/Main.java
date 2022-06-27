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
	static int intTime = 600;
	
	public static void main(String args[]) {
		//---------------------------------FRAME----------------------
		JFrame frame = new JFrame();
		frame.setSize(1500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Countdown timer");
		frame.setLayout(new GridLayout(3,3,1,0));
		
		//---------------------------------CURRENT SECTION PANEL-------------------
		JPanel currentSection = new JPanel();
		currentSection.setBackground(new Color(41,19,46));
		
		//---------------------------------BLANK PANEL 1-------------------
		JPanel blankPanel1 = new JPanel();
		blankPanel1.setBackground(new Color(41,19,46));
				
		//---------------------------------TIMER PANEL-------------------
		JPanel timerPanel = new JPanel();
		timerPanel.setBackground(new Color(41,19,46));
		
		//---------------------------------START BUTTON PANEL-------------------
		JPanel startButtonPanel = new JPanel();
		startButtonPanel.setBackground(new Color(41,19,46));
		
		//---------------------------------BLANK PANEL 2-------------------
		JPanel blankPanel2 = new JPanel();
		blankPanel2.setBackground(new Color(41,19,46));
				
		//---------------------------------STOP BUTTON PANEL-------------------
		JPanel stopButtonPanel = new JPanel();
		stopButtonPanel.setBackground(new Color(41,19,46));
		
		//---------------------------------TIME SETTER PANEL-------------------
		JPanel timeSetterPanel = new JPanel();
		timeSetterPanel.setBackground(new Color(41,19,46));
		timeSetterPanel.setLayout(new GridLayout(2,2));
		
		//---------------------------------NO OF SECTIONS PANEL-------------------
		JPanel sectionNoPanel = new JPanel();
		sectionNoPanel.setBackground(new Color(41,19,46));
		sectionNoPanel.setLayout(new GridLayout(2,3));
		
		//---------------------------------SECTION RATIO PANEL-------------------
		JPanel sectionRatioPanel = new JPanel();
		sectionRatioPanel.setBackground(new Color(41,19,46));
		sectionRatioPanel.setLayout(new GridLayout(2,5));
		
		//---------------------------------BLANK LABELS-------------------------
		// can we use the same blank over and over again?
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel blank3 = new JLabel();
		JLabel blank4 = new JLabel();
		JLabel blank5 = new JLabel();
		JLabel blank6 = new JLabel();
		
		JLabel colon = new JLabel(":", SwingConstants.CENTER);
		colon.setFont(new Font("Helvetica", Font.BOLD, 25));
		colon.setForeground(new Color(222,0,42));
		//---------------------------------BUTTONS------------------------
		ButtonAction button = new ButtonAction();
		
		//---------------------------------FINAL ADDITIONS----------------
		/*
		mainPanel.add(label1);
		mainPanel.add(button.timeMinutes);
		mainPanel.add(button.time);
		mainPanel.add(label4);
		mainPanel.add(button.upButton);
		mainPanel.add(button.startButton);
		mainPanel.add(button.stopButton);
		mainPanel.add(button.downButton);
		frame.add(mainPanel);
		*/
		//Adding to the Panels
		
		currentSection.add(button.currSection);
		timerPanel.add(button.mainTimer);
		startButtonPanel.add(button.startButton);
		stopButtonPanel.add(button.stopButton);
		
		timeSetterPanel.add(button.timeSetterMinutes);
		timeSetterPanel.add(button.timeSetterSeconds);
		timeSetterPanel.add(button.timeSetterUp);
		timeSetterPanel.add(button.timeSetterDown);
		
		sectionNoPanel.add(blank1);
		sectionNoPanel.add(button.noSections);
		sectionNoPanel.add(blank2);
		sectionNoPanel.add(button.sectionUp);
		sectionNoPanel.add(blank3);
		sectionNoPanel.add(button.sectionDown);
		
		sectionRatioPanel.add(button.ratioX);
		sectionRatioPanel.add(blank4);
		sectionRatioPanel.add(colon);
		sectionRatioPanel.add(blank5);
		sectionRatioPanel.add(button.ratioY);
		sectionRatioPanel.add(button.Xup);
		sectionRatioPanel.add(button.Xdown);
		sectionRatioPanel.add(blank6);
		sectionRatioPanel.add(button.Yup);
		sectionRatioPanel.add(button.Ydown);
		
		//adding Panels to the frame
		frame.add(currentSection);
		frame.add(blankPanel1);
		frame.add(timerPanel);
		frame.add(startButtonPanel);
		frame.add(blankPanel2);
		frame.add(stopButtonPanel);
		frame.add(timeSetterPanel);
		frame.add(sectionNoPanel);
		frame.add(sectionRatioPanel);
		
		frame.setVisible(true);  
		
	}
}
 
class ButtonAction implements ActionListener{
	/*
	JButton upButton;
	JButton downButton;
	JButton startButton;
	JButton stopButton;
	JLabel time;
	JLabel timeMinutes;
	String stringTime;
	String stringTimeMinutes;
	*/
	JLabel currSection; //Label that shows the current section during countdown
	JLabel mainTimer; //Label that shows the actual countdown
	JButton startButton; //Button starts the timer
	JButton stopButton; //Button stops the timer
	
	JLabel timeSetterMinutes; // Shows the minutes when setting the time
	JLabel timeSetterSeconds; //Shows the seconds when setting the time
	JButton timeSetterUp;
	JButton timeSetterDown;
	
	JLabel noSections; //Shows the number of sections
	JButton sectionUp; // increments the number of sections
	JButton sectionDown;
	
	JLabel ratioX; // Let the sub section ratio be X:Y, then this is X.
	JLabel ratioY;
	JButton Xup;
	JButton Xdown;
	JButton Yup;
	JButton Ydown;
	
	int noOfSections = 10; //stores the number of sections
	int secsPerSection = Main.intTime / noOfSections;
	int currentSection = (Main.intTime/secsPerSection) + 1;
	int sectionRatioX = 3;
	int sectionRatioY = 1;
	
	int sectionTimerSeconds = (Main.intTime % secsPerSection);
	int sectionTimerMinutes = (sectionTimerSeconds) / 60;
	
	int sectionTimeRed = (secsPerSection / (sectionRatioX + sectionRatioY))*sectionRatioX;
	//----------------Timer and Timer Task--------------
	/*
	Timer timer = new Timer();
	
	TimerTask task = new TimerTask() {
		
		//int counter = 10;
		public void run() {
			if(Main.intTime>0) {
				System.out.println(Main.intTime+ " seconds");
				Main.intTime--;
				time.setText(String.valueOf(Main.intTime % 60));
				timeMinutes.setText(String.valueOf(Main.intTime/60));
				if((Main.intTime % 60)<=60 && (Main.intTime % 60)>15) {
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
	*/
	Timer timer = new Timer();
	
	TimerTask task = new TimerTask() {
		public void run() {
			if(Main.intTime>0) {
				Main.intTime--;
				currentSection = (Main.intTime/secsPerSection) + 1;
				currSection.setText(String.valueOf(currentSection));
				
				sectionTimerSeconds = (Main.intTime % secsPerSection);
				sectionTimerMinutes = (sectionTimerSeconds) / 60;
				mainTimer.setText(String.valueOf(sectionTimerMinutes) +" : " + String.valueOf(sectionTimerSeconds));
				if(sectionTimerSeconds<secsPerSection && sectionTimerSeconds>=(secsPerSection-sectionTimeRed)) {
					mainTimer.setForeground(new Color(222,0,42));
				}
				else {
					mainTimer.setForeground(new Color(66,135,245));
				}
				
			}
			else {
				timer.cancel();
			}
		}
	};
	public ButtonAction() {
		//The following image icons will be used by all the buttons
		ImageIcon up = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\up_super_smol.png");
		ImageIcon down = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\down_super_smol.png");
		
		//-------------------------TIME SETTER BUTTONS---------------------------
		timeSetterUp = new JButton();
		timeSetterDown = new JButton();
		
		timeSetterUp.addActionListener(this);
		timeSetterDown.addActionListener(this);
		
		timeSetterUp.setFocusable(false);
		timeSetterDown.setFocusable(false);
		
		timeSetterUp.setBackground(new Color(50,20,80));
		timeSetterDown.setBackground(new Color(50,20,80));
		
		timeSetterUp.setIcon(up);
		timeSetterDown.setIcon(down);
		
		//-------------------------SECTION SETTER BUTTONS------------------------
		sectionUp = new JButton();
		sectionDown = new JButton();
		
		sectionUp.setFocusable(false);
		sectionDown.setFocusable(false);
		
		sectionUp.setBackground(new Color(50,20,80));
		sectionDown.setBackground(new Color(50,20,80));
		
		sectionUp.addActionListener(this);
		sectionDown.addActionListener(this);
		
		sectionUp.setIcon(up);
		sectionDown.setIcon(down);
		
		//-------------------------RATIO SETTER BUTTONS-------------------------
		Xup = new JButton();
		Xdown = new JButton();
		Yup = new JButton();
		Ydown = new JButton();
		
		Xup.setFocusable(false);
		Xdown.setFocusable(false);
		Yup.setFocusable(false);
		Ydown.setFocusable(false);
		
		Xup.setBackground(new Color(50,20,80));
		Xdown.setBackground(new Color(50,20,80));
		Yup.setBackground(new Color(50,20,80));
		Ydown.setBackground(new Color(50,20,80));
		
		Xup.addActionListener(this);
		Xdown.addActionListener(this);
		Yup.addActionListener(this);
		Ydown.addActionListener(this);
		
		Xup.setIcon(up);
		Xdown.setIcon(down);
		Yup.setIcon(up);
		Ydown.setIcon(down);
		
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
		
		//---------------CURRENT SECTION LABEL--------------------------------------
		currSection = new JLabel(String.valueOf(currentSection), SwingConstants.CENTER);
		currSection.setFont(new Font("Helvetica", Font.PLAIN, 50));
		currSection.setForeground(new Color(222,0,42));
		
		//---------------MAIN TIMER LABEL-------------------------------------------
		String mainTime = String.valueOf(sectionTimerSeconds) + " : " + String.valueOf(sectionTimerMinutes);
		mainTimer = new JLabel(mainTime, SwingConstants.CENTER);
		mainTimer.setFont(new Font("Helvetica", Font.PLAIN, 50));
		mainTimer.setForeground(new Color(222,0,42));
		
		//----------------TIME SETTER MINUTES AND SECONDS LABELS---------------------
		String timeSetMinutes = String.valueOf(Main.intTime/60);
		timeSetterMinutes = new JLabel(timeSetMinutes, SwingConstants.CENTER);
		timeSetterMinutes.setFont(new Font("Helvetica", Font.PLAIN, 25));
		timeSetterMinutes.setForeground(new Color(222,0,42));
		
		String timeSetSeconds = String.valueOf(Main.intTime%60);
		timeSetterSeconds = new JLabel(timeSetSeconds, SwingConstants.CENTER);
		timeSetterSeconds.setFont(new Font("Helvetica", Font.PLAIN, 25));
		timeSetterSeconds.setForeground(new Color(222,0,42));
		
		//-----------------NUMBER OF SECTIONS SETTER LABEL----------------------------
		noSections = new JLabel(String.valueOf(noOfSections), SwingConstants.CENTER);
		noSections.setFont(new Font("Helvetica", Font.PLAIN, 25));
		noSections.setForeground(new Color(222,0,42));
		
		//-----------------RATIO SETTER LABELS----------------------------------------
		ratioX = new JLabel(String.valueOf(sectionRatioX), SwingConstants.CENTER);
		ratioX.setFont(new Font("Helvetica", Font.PLAIN, 25));
		ratioX.setForeground(new Color(222,0,42));
		
		ratioY = new JLabel(String.valueOf(sectionRatioY), SwingConstants.CENTER);
		ratioY.setFont(new Font("Helvetica", Font.PLAIN, 25));
		ratioY.setForeground(new Color(222,0,42));
		
		/*
		//---------------Time Label Seconds---------------
		stringTime= String.valueOf(Main.intTime % 60);
		time = new JLabel(stringTime,SwingConstants.CENTER);
		time.setFont(new Font("Helvetica", Font.PLAIN, 50));
		time.setForeground(new Color(222,0,42));
		
		//----------------Time Label Minutes--------------
		stringTimeMinutes = String.valueOf(Main.intTime/60);
		timeMinutes = new JLabel(stringTimeMinutes, SwingConstants.CENTER);
		timeMinutes.setFont(new Font("Helvetica", Font.PLAIN, 50));
		timeMinutes.setForeground(new Color(222,0,42));
		*/
		
		/*
		//-------------------------Up Button-------------------------------------
		upButton = new JButton();
		upButton.addActionListener(this);
		upButton.setFocusable(false);
		upButton.setBackground(new Color(50,20,80));
		//upButton.setBounds(10, 10, 100, 50); // x, y, width, height
		
		upButton.setIcon(up);
		
		//-------------------------Down Button------------------------------------
		downButton= new JButton();
		downButton.addActionListener(this);
		downButton.setFocusable(false);
		downButton.setBackground(new Color(50,20,80));
		//downButton.setBounds(10, 70, 100, 50);
		
		downButton.setIcon(down);
		*/
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		if(e.getSource()==upButton) {
			//System.out.println("Button clicked!");
			Main.intTime++;
			time.setText(String.valueOf(Main.intTime % 60));
			timeMinutes.setText(String.valueOf(Main.intTime/60));
			
		}
		else if(e.getSource()==downButton) {
			Main.intTime--;
			time.setText(String.valueOf(Main.intTime % 60));
			timeMinutes.setText(String.valueOf(Main.intTime/60));
		}
		else if(e.getSource()==startButton) {
			timer.schedule(task, 0, 1000);
		}
		else if(e.getSource()==stopButton) {
			timer.cancel();
		}
	*/
		if(e.getSource()==timeSetterUp) {
			Main.intTime++;
			timeSetterMinutes.setText(String.valueOf(Main.intTime/60));
			timeSetterSeconds.setText(String.valueOf(Main.intTime%60));
		}
		else if(e.getSource()==timeSetterDown) {
			Main.intTime--;
			timeSetterSeconds.setText(String.valueOf(Main.intTime%60));
			timeSetterMinutes.setText(String.valueOf(Main.intTime/60));
		}
		else if(e.getSource()==sectionUp) {
			noOfSections++;
			secsPerSection = Main.intTime / noOfSections; // calculate this value again. do we need to do this?
			sectionTimeRed = (secsPerSection / (sectionRatioX + sectionRatioY))*sectionRatioX;
			noSections.setText(String.valueOf(noOfSections));
		}
		else if(e.getSource()==sectionDown) {
			noOfSections--;
			secsPerSection = Main.intTime / noOfSections; // calculate this value again. do we need to do this?
			sectionTimeRed = (secsPerSection / (sectionRatioX + sectionRatioY))*sectionRatioX;
			noSections.setText(String.valueOf(noOfSections));
		}
		else if(e.getSource()==Xup) {
			sectionRatioX++;
			sectionTimeRed = (secsPerSection / (sectionRatioX + sectionRatioY))*sectionRatioX;
			ratioX.setText(String.valueOf(sectionRatioX));
		}
		else if(e.getSource()==Xdown) {
			sectionRatioX--;
			sectionTimeRed = (secsPerSection / (sectionRatioX + sectionRatioY))*sectionRatioX;
			ratioX.setText(String.valueOf(sectionRatioX));
		}
		else if(e.getSource()==Yup) {
			sectionRatioY++;
			sectionTimeRed = (secsPerSection / (sectionRatioX + sectionRatioY))*sectionRatioX;
			ratioY.setText(String.valueOf(sectionRatioY));
		}
		else if(e.getSource()==Ydown) {
			sectionRatioY--;
			sectionTimeRed = (secsPerSection / (sectionRatioX + sectionRatioY))*sectionRatioX;
			ratioY.setText(String.valueOf(sectionRatioY));
		}
		else if(e.getSource()==startButton) {
			timer.schedule(task, 0, 1000);
		}
		else if(e.getSource()==stopButton) {
			timer.cancel();
		}
	}
	
}
