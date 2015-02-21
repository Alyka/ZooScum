
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
   	private ArrayList<Animal> tailArray = new ArrayList<Animal>(); // tail of Train
    
  /**
	* Constructor Train - initializes train on screen
    */
    public Train(){
		this.Xpos = 0;
		this.Ypos = 512;
    }

    /**
     * Method getTA   - returns animal array of captured animals
     *        @return - tailArray of Animal objects
     */
    public ArrayList<Animal> getTA(){ return tailArray; };
	
    /**
     * Method incShift - increments shift s train moves faster
     */	
	public void incShift(){
		SHIFT+=2;
	}
	
    // sets Direction of train to left
    public void setLeft() { 
    	this.left = true; 
    	this.right = false;
    	this.up = false;
    	this.down = false;
    }
    // sets Direction of train to right
    public void setRight() {
    	this.left = false; 
    	this.right = true;
    	this.up = false;
    	this.down = false;
    }    
    // sets Direction of train to up
    public void setUp() {
    	this.left = false; 
    	this.right = false;
    	this.up = true;
    	this.down = false;
    }
    // sets Direction of train to down
    public void setDown() {
		this.left = false; 
    	this.right = false;
    	this.up = false;
    	this.down = true;
    }
	
    /**
     * returns horizontal position of train
     *          @return - Xpos integer coordinate
     */
    public int getX(){ return Xpos; }
   
	/**
     *  returns vertical position of train
     *          @return - Ypos integer coordinate
     */   
    public int getY(){ return Ypos; }
	
    /**
     * sets x-coordinate position
     *          @param - new x-coordinate
     */
    public void setX(int x){ Xpos = x; }
	
	
	/**
     *  sets y-coordinate position
     *          @param - new y-coordinate
     */
    public void setY(int y){ Ypos = y; }
    
    /**
     * Method setLeft - sets value of left check
     *        @param  - new left value
     */
    public void setLeft(boolean x) { left = x; }
    
    /**
     * Method setRight - sets value of right check
     *        @param   - new right value
     */
    public void setRight(boolean x) { right = x; }    
    
    /**
     * Method setUp  - sets value of up check
     *        @param - new up value
     */
    public void setUp(boolean x) { up = x; }

    /**
     * Method setDown - sets value of down check
     *        @param  - new down value
     */
    public void setDown(boolean x) { down = x; }
	
     /**
     * Method getLeft - gets value of left check
     * 		  @return - left bool check
     */
    public boolean getLeft() { return left; }  
    
    /**
     * Method getRight - gets value of right check
     * 		  @return  - right bool check
     */
    public boolean getRight() { return right; }
    
    /**
     * Method getUp   - gets value of up check
     * 		  @return - up bool check
     */
    public boolean getUp() { return up; }
 	 
 	 /**
     * Method getDown - gets value of down check
     * 		  @return - down bool check
     */
    public boolean getDown() { return down; }

    /**
       Method move moves the head of the train and makes
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
