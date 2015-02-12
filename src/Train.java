import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class Train{

 	private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
	
	int Xpos, Ypos;
 	private final int SHIFT = 64;	
   	final int height = 10;
   	final int width = 10;
    BufferedImage image;
    
    public Train(){
		this.Xpos = 0;
		this.Ypos = 512;
    }

    //get x pos of the cell
    public int getX(){ return Xpos; }
   
    //get y pos of the cell
    public int getY(){ return Ypos; }
	
    //set x pos of the cell
    public void setX(int x){ Xpos = x; }
	
    //set y pos of the cell
    public void setY(int y){ Ypos = y; }
    
    public void setLeft(boolean x) { left = x; }
    public void setRight(boolean x) { right = x; }    
    public void setUp(boolean x) { up = x; }
	public void setDown(boolean x) { down = x; }
	
	public boolean getLeft() { return left; }  
    public boolean getRight() { return right; }
    public boolean getUp() { return up; }
	public boolean getDown() { return down; }
    
    /**
       Method moveTrain moves the head of the train and makes
       all of the train parts follow
    */
    
  	public void move(){
		if (left){ this.setX(this.getX() - SHIFT); }
		if (right){ this.setX(this.getX() + SHIFT); }
		if (up){ this.setY(this.getY() - SHIFT); }
		if (down){ this.setY(this.getY() + SHIFT); }
 	}

    //get object's current image
   /* public BufferedImage getImage(){
	return this.image;
    }
    
    //set object's current image
    public void setImage(String path, int col, int row){
	try{
	    this.image = ImageIO.read(new File(path));
	}catch(IOException e){
	    System.out.println("Image did read\n");
	}
	//waiting on sprite sheet to generate params
	this.image = this.image.getSubimage(col, row, width, height);
    }*/


}
