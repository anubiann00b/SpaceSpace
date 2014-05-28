package se.lignum.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import se.lignum.main.scenes.GameScene;
import se.lignum.main.utils.ImageLoader;


public class Instance {

	
	public double x,y;
	Image sprite;
	public boolean marked = false;

	public Instance(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void tick(){}

	public void draw(Graphics g){
		drawDefaultSprite(g);
		if(marked){
			g.setColor(Color.BLUE);
			g.drawRect((int)x-sprite.getWidth(null)/2, (int)y-sprite.getHeight(null)/2,(int) sprite.getWidth(null)*2,(int) sprite.getHeight(null)*2);
		}
	}

	public void drawDefaultSprite(Graphics g){
		if(this.sprite != null){
			g.drawImage(this.sprite,(int)x,(int)y,null);
		}else{
			System.out.println("Trying to draw a null sprite");
		}
	}

	public Image getSprite(){
		return this.sprite;
	}

	public void setSprite(String imagePath){
		this.sprite = ImageLoader.load(imagePath);
	}
	
	public boolean isInSelection(){
		if(this.x >= Game.mouse.clickedX && this.x < Game.mouse.getX() && this.y > Game.mouse.clickedY && this.y < Game.mouse.getY() && GameScene.mb_left_hold){
			return true;
		}
		
		return false;
	}

}
