package mainPackage;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class InfoFrame extends JFrame  {

	JPanel mainPanel1 = new JPanel();
	JPanel mainPanel2 = new JPanel();
	JPanel mainPanel3 = new JPanel();
	JPanel centerPanel = new JPanel();
	JLabel label1, label2, label3;
	int HEIGHT = 900;
	int WIDTH = 950;
	int licznik;
	
	
	public InfoFrame() throws HeadlessException, IOException {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setTitle("Instrukcja");
		this.setLayout(new BorderLayout());
		ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
		InputStream input1 = classLoader1.getResourceAsStream("strona1.png");
		Image image1 = ImageIO.read(input1);
		
		ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
		InputStream input2 = classLoader2.getResourceAsStream("strona2.png");
		Image image2 = ImageIO.read(input2);
		
		ClassLoader classLoader3 = Thread.currentThread().getContextClassLoader();
		InputStream input3 = classLoader3.getResourceAsStream("strona3.png");
		Image image3 = ImageIO.read(input3);
		
		
		label1 = new JLabel(new ImageIcon(image1));
		label2 = new JLabel(new ImageIcon(image2));
		label3 = new JLabel(new ImageIcon(image3));
		
		
		
		
		
		this.add(centerPanel,BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(mainPanel1,BorderLayout.NORTH);
		centerPanel.add(mainPanel2,BorderLayout.CENTER);
		centerPanel.add(mainPanel3,BorderLayout.SOUTH);
		
		
		mainPanel1.add(label1);
		mainPanel2.add(label2);
		mainPanel3.add(label3);
	}

	public InfoFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public InfoFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public InfoFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	
	
		
	}
	
	


