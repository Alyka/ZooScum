
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class Broom{
    private int Xpos, Ypos;
    
    private final int height = 10;
    private final int width = 10;
	private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false; 
    private final int SHIFT = 40;
    
    public void setXY(int x, int y){
    	Xpos = x;
    	Ypos = y;
    }
    
    //get x pos of the cell
    public int getX(){ return Xpos; }
   
    //get y pos of the cell
    public int getY(){ return Ypos; }
	
    //set x pos of the cell
    public void setX(int x){ Xpos = x; }
	
    //set y pos of the cell
    public void setY(int y){ Ypos = y; }
    
    // set direction of the broom
    public void setDirection(Train train){
    	if (train.getLeft()){
    		this.left = true;
    		this.right = false;
    		this.down = false;
    		this.up = false;
    	}
    	if (train.getRight()){
    		this.right = true;
    		this.left = false;
    		this.down = false;
    		this.up = false;
    	}
    	if (train.getUp()){
    		this.up = true;
    		this.left = false;
    		this.right = false;
    		this.down = false;
    	}
    	if (train.getDown()){
    		this.down = true;
    		this.left = false;
    		this.right = false;
    		this.up = false;
    	}
    }
    
    // move broom
    public void move(){
    	if (left){ this.setX(this.getX() - SHIFT); }
		if (right){ this.setX(this.getX() + SHIFT); }
		if (up){ this.setY(this.getY() - SHIFT); }
		if (down){ this.setY(this.getY() + SHIFT); }
    }
}