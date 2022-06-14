package mainPackage;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class ImagePanel extends JPanel implements Runnable {
	
	private BufferedImage image;
	int HEIGHT, WIDTH;
	List<Ryba> ryby = new ArrayList<Ryba>();
	boolean run = false;
	BufferedImage[] rybyWprawo;
	BufferedImage[] rybyWlewo;
	BufferedImage haczyk;
	Wedka wedka;
	boolean kliknieta = false;
	int xWedki = 300;
	MainFrame frame;
	String punkty = "0/300";
	int iloscPunktow = 0;
	int level = 1;

	

	public ImagePanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		super();
		HEIGHT = frame.getHEIGHT();
		WIDTH = frame.getWIDTH();
		this.frame = frame;
		ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
		InputStream resource = classLoader1.getResourceAsStream("ryby_tlo.jpg");
		 try {
		 image = ImageIO.read(resource);
		 } catch (IOException e) {
		 System.err.println("Blad odczytu obrazka");
		 e.printStackTrace();
		 }
		 Dimension dimension =
				 new Dimension(image.getWidth(), image.getHeight());
				  setPreferredSize(dimension);
				  
		/*ScheduledExecutorService fps = Executors.newSingleThreadScheduledExecutor();
		fps.scheduleAtFixedRate(this, 0, 20, TimeUnit.MILLISECONDS);
		nextLevel(0);*/
				  
		rybyWprawo = new BufferedImage[2];
		rybyWlewo = new BufferedImage[2];
		
		ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
		InputStream resource2 = classLoader2.getResourceAsStream("czerwona_lewo.png");
		 try {
		 rybyWlewo[0] = ImageIO.read(resource2);
		 } catch (IOException e) {
		 System.err.println("Blad odczytu obrazka");
		 e.printStackTrace();
		 }
		 
		 ClassLoader classLoader3 = Thread.currentThread().getContextClassLoader();
			InputStream resource3 = classLoader3.getResourceAsStream("zolta_lewo.png");
			 try {
			 rybyWlewo[1] = ImageIO.read(resource3);
			 } catch (IOException e) {
			 System.err.println("Blad odczytu obrazka");
			 e.printStackTrace();
			 }
			 
		ClassLoader classLoader4 = Thread.currentThread().getContextClassLoader();
				InputStream resource4 = classLoader4.getResourceAsStream("czerwona_prawo.png");
				 try {
				 rybyWprawo[0] = ImageIO.read(resource4);
				 } catch (IOException e) {
				 System.err.println("Blad odczytu obrazka");
				 e.printStackTrace();
				 }	
				 
		ClassLoader classLoader5 = Thread.currentThread().getContextClassLoader();
					InputStream resource5 = classLoader5.getResourceAsStream("zolta_prawo.png");
					 try {
					 rybyWprawo[1] = ImageIO.read(resource5);
					 } catch (IOException e) {
					 System.err.println("Blad odczytu obrazka");
					 e.printStackTrace();
					 }	
					 
		ClassLoader classLoader6 = Thread.currentThread().getContextClassLoader();
						InputStream resource6 = classLoader6.getResourceAsStream("haczyk.png");
						 try {
						 haczyk = ImageIO.read(resource6);
						 } catch (IOException e) {
						 System.err.println("Blad odczytu obrazka");
						 e.printStackTrace();
						 }			 
					 
		wedka = new Wedka();
		wedka.setObraz(haczyk);
		MyMouseAdapter mouse = new MyMouseAdapter();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		

	}
	
	class MyMouseAdapter extends MouseInputAdapter {
	    
		
	    public void mousePressed(MouseEvent e)
	    {
	        kliknieta = true;

	    }

	    public void mouseMoved(MouseEvent e)
	    { 
	    	xWedki = e.getX();
	    	//repaint();
	    	//}
	         
	    }

	    public void mouseReleased(MouseEvent e)
	    {
	        kliknieta = false;
	    }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.drawImage(image, 0, 0, WIDTH, HEIGHT, this);
		 for(Ryba r : ryby) {
			 r.paint(g); // moze trzeba g2d
		 }
		 wedka.paint(g);
	}

	public ImagePanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	
	}

	public ImagePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public ImagePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void dodajRybe(int x, int y, int vx, BufferedImage image) {
		Ryba r = new Ryba();
		r.setPanel(this);
		r.setxPos(x);
		r.setyPos(y);
		r.setVx(vx);
		r.setObraz(image);
		
		ryby.add(r);
	}
	
	public void nextLevel(int level) {
		Random rand = new Random();
		for(int i = 0; i<10; i++) {
			dodajRybe(-rand.nextInt(300+1200*level)-100-300*i,rand.nextInt(550)+50,level+rand.nextInt(5),rybyWprawo[rand.nextInt(100)%2]);
		}
		for(int i = 0; i<10; i++) {
			dodajRybe(rand.nextInt(300+1200*level)+1500+300*i,rand.nextInt(550)+50,-level-rand.nextInt(5),rybyWlewo[rand.nextInt(100)%2]);
		}
		for(int i = 0; i<5; i++) {
			dodajRybe(-rand.nextInt(300+1200*level)-3100-300*i,rand.nextInt(550)+50,level+rand.nextInt(5),rybyWprawo[rand.nextInt(100)%2]);
		}
		for(int i = 0; i<5; i++) {
			dodajRybe(rand.nextInt(300+1200*level)+4500+300*i,rand.nextInt(550)+50,-level-rand.nextInt(5),rybyWlewo[rand.nextInt(100)%2]);
		}
	}
	
	public void przejscie(int level) {
		this.level++;
		frame.l.timer.cancel();
        frame.gornyPanelPrawy.remove(frame.l.zegarek);
        frame.l = new Licznik(frame.glownyPanel);
    frame.l.setI(30);
    frame.x=30;
    frame.y=30;
    frame.l.zegarek= new JLabel("pozosta³e sekundy:"+frame.l.getI()+ "     ");
    frame.l.zegarek.setFont(frame.label);
    frame.gornyPanelPrawy.add(frame.l.zegarek);
	frame.glownyPanel.run = true;
	frame.glownyPanel.nextLevel(level);
	frame.licznikPunktow.setText("0/200");
	frame.glownyPanel.iloscPunktow = 0;
	String s = "Poziom:" + Integer.toString(level+1);
	frame.level.setText(s);
	}
	
	public void wedkaPosition(int x) {
		
			wedka.setxPos(x);
		
	}
	public boolean wedkaKliknieta() {
		return kliknieta;
	}
	public void removeRyby(){
		ryby.removeAll(ryby);
	}
	// width - 1300, height - 700
	public void run() {
		if(run == true) {	
		for(Ryba r : ryby) {
			r.setxPos(r.getxPos()+r.getVx());
			}
		for(Ryba r : ryby) {
			if(r.trafiona == false) {
			r.rybaTrafiona(wedka);
			if(r.trafiona == true) {
			wedka.setyPos(wedka.getyStartPos());
			iloscPunktow += 20;
			punkty = Integer.toString(iloscPunktow) +"/200";
			frame.licznikPunktow.setText(punkty);
			}
			}
			}
		
		
		if(wedkaKliknieta() && wedka.getyPos() < wedka.getyMinPos()) {
			wedka.setyPos(wedka.getyPos()+wedka.getVy());
		}
		else if(wedka.getyPos() >= wedka.getyStartPos() && (!wedkaKliknieta())) {
			wedka.setyPos(wedka.getyPos()-wedka.getVy());
			
		}
		else {
			wedkaPosition(xWedki);
		}
			if(iloscPunktow == 200) {
				removeRyby();
				przejscie(level);
			}
			repaint();
	}
	}

}
