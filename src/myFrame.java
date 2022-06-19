import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class myFrame extends JFrame implements ActionListener{
	JButton upButton;
	myFrame(){
		this.setSize(500, 500);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Countdown timer");
		
		upButton = new JButton();
		upButton.addActionListener(this);
		upButton.setFocusable(false);
		upButton.setBackground(new Color(50,20,80));
		upButton.setBounds(10, 10, 100, 50);
		
		ImageIcon up = new ImageIcon("C:\\Users\\ishan\\eclipse-workspace\\Countdown Timer\\up.png");
		upButton.setIcon(up);
		
		this.add(upButton);
		this.setVisible(true); // you should put this line at the end or the components won't show up. and a whole bunch of issues
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==upButton) {
			//System.out.println("Button clicked!");
			Main.intTime++;
			System.out.println(Main.intTime);
		}
	}
}
