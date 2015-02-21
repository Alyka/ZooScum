package src;

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
 * Class Broom - creates a Broom class to track and move broom around screen
 *
 * @author	Jennifer Cryan
 * @author 	Jessica Huang
 * @author 	Jazarie Thach
 * @author 	Felica Truong
 * @author 	Josephine Vo
 * @version for CS48, Winter 2015, UCSB
 */
public class Broom {
    private final int SHIFT = 40; // speed of broom movement
    
    private int       Xpos;       // x-coordinate position
    private int       Ypos;       // y-coordinate position
    private boolean   left;       // check for left movement
    private boolean   right;      // check for right movement
    private boolean   up;         // check for up movement
    private boolean   down;       // check for down movement
    {
        left  = false;
        right = false;
        up    = false;
        down  = false;
    }
    
    /**
     * Method setXY  - sets x & y coordinates of broom
     *       @param - new x & y coordinates to set
     */
    public void setXY(int x, int y) {
        Xpos = x;
        Ypos = y;
    }
    
    /**
     * Method getX    - returns horizontal position of train
     *        @return - Xpos integer coordinate
     */
    public int getX() {
        return Xpos;
    }
    
    /**
     * Method getY    - returns vertical position of train
     * 		  @return - Ypos integer coordinate
     */
    public int getY() {
        return Ypos;
    }
    
    /**
     * Method setX   - sets x-coordinate position
     *        @param - new x-coordinate
     */
    public void setX(int x) {
        Xpos = x;
    }
    
    /**
     * Method setY   - sets y-coordinate position
     *        @param - new y-coordinate
     */
    public void setY(int y) {
        Ypos = y;
    }
    
    /**
     * Method setDirection - sets direction of broom
     *        @param       - train to get direction of
     */
    public void setDirection(Train train) {
        if (train.getLeft()) {
            this.left  = true;
            this.right = false;
            this.down  = false;
            this.up    = false;
        }
        if (train.getRight()) {
            this.right = true;
            this.left  = false;
            this.down  = false;
            this.up    = false;
        }
        if (train.getUp()) {
            this.up    = true;
            this.left  = false;
            this.right = false;
            this.down  = false;
        }
        if (train.getDown()) {
            this.down  = true;
            this.left  = false;
            this.right = false;
            this.up    = false;
        }
    }// setDirection
    
    /**
     * Method move - moves broom across screen
     */
    public void move(){
        if (left) {
            this.setX(this.getX() - SHIFT);
        }
        if (right) {
            this.setX(this.getX() + SHIFT);
        }
        if (up) {
            this.setY(this.getY() - SHIFT);
        }
        if (down) {
            this.setY(this.getY() + SHIFT);
        }
    }// move
}// Broom