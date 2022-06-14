package mainPackage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainFrame extends JFrame implements ActionListener {
	
	
	int HEIGHT;
	int WIDTH;
	int poziom = 1;
	JPanel gornyPanel;
	
	JPanel gornyPanelPrawy;
	ImagePanel glownyPanel;  
	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	JMenuBar menuBar = new JMenuBar();
	
	JLabel level;
	JLabel licznikPunktow;
	
	Font label = new Font("TimesRoman", Font.ROMAN_BASELINE, 18);
    Licznik l;
    int x = 30; 
    int y = 30;
  
	

	

	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		gornyPanel = new JPanel();
		gornyPanelPrawy = new JPanel();
		level = new JLabel();
		licznikPunktow = new JLabel();
		this.setHEIGHT(700);
		this.setWIDTH(1300);
		glownyPanel = new ImagePanel(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setTitle("Lowienie Ryb");
		this.setResizable(false);
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		gornyPanel.setSize(WIDTH,HEIGHT/10);
		gornyPanel.setLayout(new BorderLayout());
		glownyPanel.setSize(WIDTH, HEIGHT);
		this.add(glownyPanel, BorderLayout.CENTER);
		this.add(gornyPanel, BorderLayout.NORTH);
		
		l = new Licznik(glownyPanel);
		l.setI(30);
		l.zegarek.setText("pozosta³e sekundy:"+l.getI()+ "     ");
		l.timer.cancel();
		l.zegarek.setFont(label);
		l.zegarek.setFont(label);
		 level.setFont(label);
	     licznikPunktow.setFont(label);
		
		
		
		gornyPanel.add(gornyPanelPrawy, BorderLayout.LINE_END);
		
		
		
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem wznowRozpocznij = new JMenuItem("Wznow/Rozpocznij");
		JMenuItem pomoc = new JMenuItem("Pomoc");
		JMenuItem pauza = new JMenuItem("Pauza");
		gornyPanel.add(menuBar, BorderLayout.LINE_START);
		menu.add(wznowRozpocznij);
		menu.add(pomoc);
		menu.add(pauza);
		
		
		
		level.setText("Poziom:1  ");
		
		licznikPunktow.setText("0/200");
		gornyPanelPrawy.add(level);
		gornyPanelPrawy.add(licznikPunktow);
		gornyPanelPrawy.add(l.zegarek);
		ScheduledExecutorService fps = Executors.newSingleThreadScheduledExecutor();
		fps.scheduleAtFixedRate(glownyPanel, 0, 20, TimeUnit.MILLISECONDS);
		
		pauza.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				x = l.getI();
				l.timer.cancel();
				glownyPanel.run = false;
				JOptionPane.showMessageDialog(null,"Zapauzowano gre", "",JOptionPane.INFORMATION_MESSAGE);
			}});
		
		wznowRozpocznij.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				y=l.getI();

				//ROZPOCZÊCIE OD NOWA
                if (y==0 || y==30)
                {
                    l.timer.cancel();
                    gornyPanelPrawy.remove(l.zegarek);
                    l = new Licznik(glownyPanel);
                l.setI(30);
                x=30;
                y=30;
                l.zegarek= new JLabel("pozosta³e sekundy:"+l.getI()+ "     ");
                l.zegarek.setFont(label);
                gornyPanelPrawy.add(l.zegarek);
        		glownyPanel.run = true;
        		glownyPanel.nextLevel(0);
        		licznikPunktow.setText("0/200");
        		glownyPanel.iloscPunktow = 0;
        		level.setText("Poziom:1  ");
        		
                }
				
				//WZNOWIENIE
                else if (x>0 ^ x>y)
                {
                    l.timer.cancel();
                    gornyPanelPrawy.remove(l.zegarek);
                    l = new Licznik(glownyPanel);
                l.setI(x);
                l.zegarek= new JLabel("pozosta³e sekundy:"+l.getI()+ "     ");
                l.zegarek.setFont(label);
                gornyPanelPrawy.add(l.zegarek);
                glownyPanel.run = true;
             
                }
			}});
		
		pomoc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
				
					InfoFrame info = new InfoFrame();
					info.setVisible(true);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		
		
	}

	public MainFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public MainFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public MainFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		//ScheduledExecutorService fps = (ScheduledExecutorService) Executors.newSingleThreadExecutor();
		//fps.scheduleAtFixedRate(glownyPanel, 0, 20, TimeUnit.MILLISECONDS);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
