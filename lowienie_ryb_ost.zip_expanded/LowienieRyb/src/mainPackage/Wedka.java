package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Wedka {
	
	BufferedImage obraz;
	ImagePanel panel;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	private int xPos = 500;
	private int yPos = 20;
	private int width = 30;
	private int height = 30;
	private int yStartPos = 20;
	private int yMinPos = 600;
	private int vy = 10;
	
	public BufferedImage getObraz() {
		return obraz;
	}
	public void setObraz(BufferedImage obraz) {
		this.obraz = obraz;
	}
	public ImagePanel getPanel() {
		return panel;
	}
	public void setPanel(ImagePanel panel) {
		this.panel = panel;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public void setVy(int vy) {
		this.vy = vy;
	}
	public int getVy() {
		return vy;
	}
	public int getyStartPos() {
		return yStartPos;
	}
	public int getyMinPos() {
		return yMinPos;
	}
	
	

	public Wedka() {
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		//g.fillRect(xPos, yPos, width, height);
		g.drawImage(obraz,xPos,yPos,width,height,panel);
		g.drawLine(xPos+width/2+6,yPos,xPos+width/2+6, yPos-2000);
		
	}

}
