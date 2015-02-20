import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

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
    
    public Animal(){}
    
    public Animal(int x, int y){
    	this.Xpos = x;
    	this.Ypos = y;
    }
    
    //get x pos of the cell
    public int getX(){ return Xpos; }
   
    //get y pos of the cell
    public int getY(){ return Ypos; }

    //set x pos of the cell
    public void setX(int x){ Xpos = x; }
	
    //set y pos of the cell
    public void setY(int y){ Ypos = y; }

    public void setXY(int x, int y){
    	Xpos = x;
    	Ypos = y;
    }
    
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
	
    public boolean isDead(){ return this.dead; }
	
	public void setDead(){ 
		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;
    	URL bloodURL =  getClass().getResource("graphics/blood.png");//blood
    	stateIM = new ImageIcon(bloodURL).getImage(); 
    	this.dead = true; 
    }
    
    public Image getIM() {
    	stateIM = new ImageIcon(stateURL).getImage();
    	return this.stateIM; 
    }
    
    public void setURL(){ 
    	URL bloodURL =  getClass().getResource("graphics/blood.png");//blood
    	stateURL = bloodURL; 
    }
    
    public void step(){
    	int random = (int)(Math.random()*4);
    	switch (random){
    		case 0: // move up
    			if ((this.Ypos + movement) < maxY){
    				this.Ypos += movement;
    			}
    		case 1: // move down
    			if ((this.Ypos - movement) > 0){
    				this.Ypos -= movement;
    			}
    		case 2: // move right
    			if ((this.Xpos + movement) < maxX){
    				this.Xpos += movement;
    			}
    		case 4: // move left
    			if ((this.Xpos - movement) > 0){
    				this.Xpos -= movement;
    			}
    	}
    }
}
