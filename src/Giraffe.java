import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class Giraffe extends Animal{
    private int Xpos, Ypos; 
    private int movement = 2;
    private int health = 2;
    private URL rightURL = getClass().getResource("graphics/giraffe/gright.png");
    private URL leftURL = getClass().getResource("graphics/giraffe/gleft.png");
    private URL upURL = getClass().getResource("graphics/giraffe/gright.png");
    private URL downURL = getClass().getResource("graphics/giraffe/gleft.png");
    private URL redURL = getClass().getResource("graphics/blood.png");//blood
    private Image raffeIM = new ImageIcon(rightURL).getImage();
    Image stateIM = raffeIM;
    
    public Giraffe(){
    	super();
    }
    
    public Giraffe(int x, int y){
    	super(x, y);
    }
	
	@Override
    public Image getIM() {
    	if (super.isDead()){
    		this.raffeIM = new ImageIcon(this.redURL).getImage(); 
    	}
    	else if (super.getLeft()){
    		this.raffeIM = new ImageIcon(this.leftURL).getImage();
    	}
    	else if (super.getUp()){
    		this.raffeIM = new ImageIcon(this.upURL).getImage();
    	}
    	else if (super.getDown()){
    		this.raffeIM = new ImageIcon(this.downURL).getImage();
    	}
    	else if (super.getRight()){
    		this.raffeIM = new ImageIcon(this.rightURL).getImage();
    	}
    	return this.raffeIM;
    }
    
    public void setURL(){ 
    	URL bloodURL = getClass().getResource("graphics/blood.png");//blood
    	this.stateIM = new ImageIcon(bloodURL).getImage();
    }

    public void damage(int dmg){
    	this.health = this.health - dmg;
    	if (health >= 0){
    		this.setDead();
    	}
    }
}