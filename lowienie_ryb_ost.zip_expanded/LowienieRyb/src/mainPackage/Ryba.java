package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Ryba {

	BufferedImage obraz;
	ImagePanel panel;
	boolean trafiona = false;
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

	private int xPos = 50;
	private int yPos = 50;
	private int width = 60;
	private int height = 40;
	int vx = 5;
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
	public int getVx() {
		return vx;
	}
	public void setVx(int vx) {
		this.vx = vx;
	}
	public void setTrafiona(boolean trafiona) {
		this.trafiona = trafiona;
	}
	public boolean getTrafiona() {
		return trafiona;
	}
	public Ryba() {
		// TODO Auto-generated constructor stub
	}
	
	public void rybaTrafiona(Wedka w) {
		boolean xTrafiony = false;
		boolean yTrafiony = false;
		if(w.getxPos()+ w.getWidth() >= xPos && w.getxPos() <= xPos + width) {
			xTrafiony = true;
		}
		if(w.getyPos()+ w.getHeight() >= yPos && w.getyPos() <= yPos + height) {
			yTrafiony = true;
		}
		if(xTrafiony == true && yTrafiony == true) {
			trafiona = true;
		}
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		//g.fillRect(xPos, yPos, width, height);
		if(trafiona == false) {
		g.drawImage(obraz,xPos,yPos,width,height,panel);
		}
		
		
	}

}
