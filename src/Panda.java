
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class Panda extends Animal{
    private int movement = 2;
    private int health = 2;
    private int attack; // Override attack
    private URL rightURL = getClass().getResource("graphics/panda/pright.png");
    private URL leftURL = getClass().getResource("graphics/panda/pleft.png");
    private URL upURL = getClass().getResource("graphics/panda/pright.png");
    private URL downURL = getClass().getResource("graphics/panda/pleft.png");
    private URL redURL = getClass().getResource("graphics/blood.png");//blood
    private Image pengIM = new ImageIcon(rightURL).getImage();
    Image stateIM = pengIM;
    
    public Panda(){
    	super();
    }
    
    public Panda(int x, int y){
    	super(x, y);
    }
	
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
