package mainPackage;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOverFrame extends JFrame {
	
	JButton button1;
	JPanel panel;

	public GameOverFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		int m = 1;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.setTitle("GAME OVER");
		panel = new JPanel(new GridLayout(1,1));
		
		button1 = new JButton("Zakoncz gre");
		ActionListener endListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(ABORT);
				System.out.println("zorbilem");
				}
			};
		
		button1.addActionListener(endListener);
		
		
		panel.add(button1);
		this.add(panel);
		
		
		
	}
	

	public GameOverFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public GameOverFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public GameOverFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
