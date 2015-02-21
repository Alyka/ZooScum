import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class Koala extends Animal{
    private int movement = 2;
    private int health = 2;
    private int attack = 2;
    private URL rightURL = getClass().getResource("graphics/koala/kright.png");
    private URL leftURL = getClass().getResource("graphics/koala/kleft.png");
    private URL upURL = getClass().getResource("graphics/koala/kright.png");
    private URL downURL = getClass().getResource("graphics/koala/kleft.png");
    private URL redURL = getClass().getResource("graphics/blood.png");//blood
    private Image pengIM = new ImageIcon(rightURL).getImage();
    Image stateIM = pengIM;
    
    public Koala(){
    	super();
    }
     // Constructor for koala class, sets x and y position
    public Koala(int x, int y){
    	super(x, y);
    }
	
		/*
		Method getIM - returns image
	*/
	@Override
    public Image getIM() {
    	if (super.isDead()){
    		this.pengIM = new ImageIcon(this.redURL).getImage(); 
    	}
    	else if (super.getLeft()){
    		this.pengIM = new ImageIcon(this.leftURL).getImage();
    	}
    	else if (super.getUp()){
    		this.pengIM = new ImageIcon(this.upURL).getImage();
    	}
    	else if (super.getDown()){
    		this.pengIM = new ImageIcon(this.downURL).getImage();
    	}
    	else if (super.getRight()){
    		this.pengIM = new ImageIcon(this.rightURL).getImage();
    	}
    	return this.pengIM;
    }
   /*
    	Method setURL - set blood.png as current state image
    */
    public void setURL(){ 
    	URL bloodURL = getClass().getResource("graphics/blood.png");//blood
    	this.stateIM = new ImageIcon(bloodURL).getImage();
    }


}
