
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
    private int SHIFT = 15;	

   	private ArrayList<Animal> tailArray = new ArrayList<Animal>();
    
    public Train(){
		this.Xpos = 0;
		this.Ypos = 512;
    }
    
    public ArrayList<Animal> getTA(){ return tailArray; };
	
	public void incShift(){
		SHIFT+=2;
	}
	
    //get x pos of the cell
    public int getX(){ return Xpos; }
   
    //get y pos of the cell
    public int getY(){ return Ypos; }
	
    //set x pos of the cell
    public void setX(int x){ Xpos = x; }
	
    //set y pos of the cell
    public void setY(int y){ Ypos = y; }
    
    public void setLeft() { 
    	this.left = true; 
    	this.right = false;
    	this.up = false;
    	this.down = false;
    }
    public void setRight() {
    	this.left = false; 
    	this.right = true;
    	this.up = false;
    	this.down = false;
    }    
    public void setUp() {
    	this.left = false; 
    	this.right = false;
    	this.up = true;
    	this.down = false;
    }
    public void setDown() {
		this.left = false; 
    	this.right = false;
    	this.up = false;
    	this.down = true;
    }
	
    public boolean getLeft() { return left; }  
    public boolean getRight() { return right; }
    public boolean getUp() { return up; }
    public boolean getDown() { return down; }
    
    /**
       Method moveTrain moves the head of the train and makes
       all of the train parts follow
    */
    
    public void move(){
    	for (int i=this.getTA().size()-1; i>=0; i--){
    		if (i==0){
    			this.getTA().get(i).setX(this.getX());
    			this.getTA().get(i).setY(this.getY());
    		}
    		else{
				this.getTA().get(i).setX(this.getTA().get(i-1).getX());
				this.getTA().get(i).setY(this.getTA().get(i-1).getY());
			}
  			if (this.getLeft()){
				this.getTA().get(i).setLeft();
			}
			if (this.getRight()){
				this.getTA().get(i).setRight();
			}
			if (this.getUp()){
				this.getTA().get(i).setUp();
			}
			if (this.getDown()){
				this.getTA().get(i).setDown();
			}			
        }
		if (left){ this.setX(this.getX() - SHIFT); }
		if (right){ this.setX(this.getX() + SHIFT); }
		if (up){ this.setY(this.getY() - SHIFT); }
		if (down){ this.setY(this.getY() + SHIFT); }
    }
}
