import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

/**
 * Class Animal - creates a Animal class to track and move animal around screen
 * 
 * @author	Jennifer Cryan
 * @author 	Jessica Huang
 * @author 	Jazarie Thach
 * @author 	Felica Truong
 * @author 	Josephine Vo
 * @version for CS48, Winter 2015, UCSB
 */
public class Animal{
    int Xpos, Ypos; 
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    boolean dead = false;
    Image stateIM;
    URL stateURL = getClass().getResource("graphics/poo.png");
    private int movement = 2;
    int maxX = 1024;
    int maxY = 768;
  		
    /**
     * Constructor Animal - empty default constructor
     */
    public Animal(){}

    /**
     * getX    - returns horizontal position of train
     *          @return - Xpos integer coordinate
     */
	public int getX() {
		return Xpos;
	}

	/**
     * getY    - returns vertical position of train
     * 		    @return - Ypos integer coordinate
     */
	public int getY() {
		return Ypos;
	}

	/**
     * setX   - sets x-coordinate position
     *          @param - new x-coordinate
     */
	public void setX(int x) {
		Xpos = x;
	}

	/**
     * setY   - sets y-coordinate position
     *          @param - new y-coordinate
     */
	public void setY(int y) {
		Ypos = y;
	}

	// set Xpos to x and Ypos to y
    public void setXY(int x, int y){
    	Xpos = x;
    	Ypos = y;
    }
    
    // Set position of animal to left
    public void setLeft() { 
    	this.left = true; 
    	this.right = false;
    	this.up = false;
    	this.down = false;
    }
    // Set position of animal to right
    public void setRight() {
    	this.left = false; 
    	this.right = true;
    	this.up = false;
    	this.down = false;
    }    
    // Set position of animal to up
    public void setUp() {
    	this.left = false; 
    	this.right = false;
    	this.up = true;
    	this.down = false;
    }
    // Set position of animal to down
    public void setDown() {
		this.left = false; 
    	this.right = false;
    	this.up = false;
    	this.down = true;
    }
	
	// check the direction of Animal
    public boolean getLeft() { return left; }  
    public boolean getRight() { return right; }
    public boolean getUp() { return up; }
    public boolean getDown() { return down; }
	
	// check if Animal is dead
    public boolean isDead(){ return this.dead; }
	
	// set Animal status to dead
	public void setDead(){ 
		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;
    	URL bloodURL =  getClass().getResource("graphics/blood.png");//blood
    	stateIM = new ImageIcon(bloodURL).getImage(); 
    	this.dead = true; 
    }
    
    // get the image of Animal
    public Image getIM() {
    	stateIM = new ImageIcon(stateURL).getImage();
    	return this.stateIM; 
    }
    
    // set the image url to a file in the graphics directory
    public void setURL(){ 
    	URL bloodURL =  getClass().getResource("graphics/blood.png");//blood
    	stateURL = bloodURL; 
    }
    
}
