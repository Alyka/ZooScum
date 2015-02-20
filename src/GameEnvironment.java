import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.Timer;
import java.awt.Color;
import javax.swing.JButton;

/** 
    Creates a JFrame that animates various animals 
    and allows for a train to move around and collect 
    the animals to return to the zoo. Tracks number 
    of animals dropped off in a given amount of time.
 
    @author  Jennifer Cryan
    @author  Jessica Huang
    @author  Jazarie Thach
    @author  Felica Truong
    @author  Josephine Vo
    @version for CS48, Winter 2015, UCSB
*/

public class GameEnvironment extends JFrame {

    Thread animate;
    DrawingPanel gridPanel = new DrawingPanel();
    JFrame animationFrame = new JFrame();
    private final int SHIFT = 15;	
    private Timer timer;
    private final int DELAY = 140;
    int maxX = 1000;
    // int maxGridX = maxX/64;
  	long startTime = 0;
  	long stopTime = 0;
  	long elapsedTime = 0;
  	int maxY = 600;
    int pWidth = 40;
    int pHeight = 40;
    int zWidth = 75;
    int zHeight = 75;
    int zooX = 75;
    int zooY = 20;
    int total = 0;
    int score = 0;
    //int maxGridY = maxY/64;
    int numAnimals = 3;
    int numTrash = 3;
    int randomize = (int)Math.ceil(Math.random() * 4); // determines animal type
    private Image trainIM;
    private Image animalIM;
    private Image zooIM;
    private Image pooIM;
    private Image trashIM;
    private Image netIM;
    boolean aBroom = false;
   	int nBroom = 10;
    Broom broom = new Broom();
    int nNet = 100;
    Net net = new Net();
    boolean aNet = false;
    private boolean gameover = false;
    private boolean pause = false;
    private int animalType;
    Train train = new Train();
    ArrayList<Animal> animalArray = new ArrayList<Animal>();
    ArrayList<Animal> trashArray = new ArrayList<Animal>();
    
		
    /**
       Method addNewBoardAnimal adds Animal to ArrayList
       and gives it an initial position on the board
    */

    private void addNewTrash() {
    	Animal a = new Animal();
		int Xpos = SHIFT*(int)Math.ceil(Math.random() * (maxX/SHIFT));
		int Ypos = SHIFT*(int)Math.ceil(Math.random() * (maxY/SHIFT));
		while((zooX - zWidth/2) < Xpos && (Xpos < (zooX + zWidth/2)) 
			  && (Ypos > zooY - zHeight/2) && (Ypos < zooY + zHeight/2)){ 
			Xpos = SHIFT*(int)Math.ceil(Math.random() * (maxX/SHIFT));
			Ypos = SHIFT*(int)Math.ceil(Math.random() * (maxY/SHIFT));
		}
		a.setX(Xpos);
		a.setY(Ypos);
		trashArray.add(a);
    }
    private void addNewBoardAnimal() {
		int Xpos = SHIFT*(int)Math.ceil(Math.random() * maxX/SHIFT);
		int Ypos = SHIFT*(int)Math.ceil(Math.random() * maxY/SHIFT);
		while((zooX - zWidth/2) < Xpos && (Xpos < (zooX + zWidth/2)) 
			  && (Ypos > zooY - zHeight/2) && (Ypos < zooY + zHeight/2)){ 
			Xpos = SHIFT*(int)Math.ceil(Math.random() * maxX/SHIFT);
			Ypos = SHIFT*(int)Math.ceil(Math.random() * maxY/SHIFT);
		}
		switch (randomize){
    		case 1:
    			Penguin p = new Penguin(Xpos, Ypos);
    			animalArray.add(p);
    			break;
    		case 2:
    			Giraffe g = new Giraffe(Xpos, Ypos);
    			animalArray.add(g);
    			break;
    		case 3:
    			Koala k = new Koala(Xpos, Ypos);
    			animalArray.add(k);
    			break;
    		case 4:
    			Panda pa = new Panda(Xpos, Ypos);
    			animalArray.add(pa);
    			break;
    		default:
    			break;
    	}	
    }
    /**
       Method addNewTailAnimal adds Animal to ArrayList
       @param animal - an Animal object
    */
    private void addNewTailAnimal(Animal tailAnimal) {
		train.getTA().add(tailAnimal);
    }

    /**
       Constructor gameEnv creates JFrame and JPanel for
       animals and train with animated JPanel
    */ 
		 
    public GameEnvironment() {
		for(int i = 0; i < numAnimals; i++) {
			addNewBoardAnimal();
		}
		for(int i = 0; i < numTrash; i++) {
	    	addNewTrash();
		}
		animationFrame.getContentPane().add(BorderLayout.CENTER, gridPanel);
		animationFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);    
		animationFrame.setSize(maxX, maxY);
		animationFrame.setVisible(true);
		gridPanel.requestFocus(); 
		
	//open gameEnvr
	//setBackground
	//start Animation
    }
	
	
    /**
       Innerclass for JPanel animation to create background
       image and add animals and train to screen along with
       a timer and score.
    */
    class DrawingPanel extends JPanel implements ActionListener {
	public DrawingPanel(){
	    addKeyListener(new Keyboard());
	    icons();
	    timer = new Timer(DELAY, this);
	    timer.start();		
	    startTime = System.currentTimeMillis();
	}
	private long getTime(){
    	stopTime = System.currentTimeMillis();
    	elapsedTime = stopTime - startTime;
    	return elapsedTime;
    }
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    showScore(g);
	    showIcons(g);
	} // end paintComponent
	public void showScore(Graphics g){
		// Displays current time & score
		g.setFont(new Font("Corsiva Hebrew", Font.PLAIN, 25));
		g.setColor(Color.BLACK);
		String displayScore = "Score: " + score;
		g.drawString(displayScore, 870, 35);
		String displayBroom = "Brooms: " + nBroom;
		g.drawString(displayBroom, 870, 60);
		String displayIns = "Press SPACE to activate broom!";
		g.drawString(displayIns, 350, 500);
		//String elapsed = "Time elapsed: " + getTime()/1000;
		//g.drawString(elapsed, 0, 45);
	}
	public void icons(){
	    URL trainURL = getClass().getResource("graphics/tright.png");//train
	    trainIM = new ImageIcon(trainURL).getImage();
		    
	    URL zooURL = getClass().getResource("graphics/pokeCenter.jpg");//zoo
	    zooIM = new ImageIcon(zooURL).getImage();
	    
	    URL pooURL = getClass().getResource("graphics/poo.jpg");//zoo
	    pooIM = new ImageIcon(pooURL).getImage();
	    
	    URL broomURL = getClass().getResource("graphics/broom.png");//zoo
	    trashIM = new ImageIcon(broomURL).getImage();
	    
	    URL netURL = getClass().getResource("graphics/net.png");//zoo
	    netIM = new ImageIcon(netURL).getImage();

	} // icons
	public void showIcons(Graphics g){
	    if (gameover == false){
		for (int i=0; i<numAnimals; i++){
		    g.drawImage(animalArray.get(i).getIM(), animalArray.get(i).getX(), animalArray.get(i).getY(), this);
		}
		for (int i=0; i<numTrash; i++){
			g.drawImage(pooIM, trashArray.get(i).getX(), trashArray.get(i).getY(), this);
		}
		g.drawImage(trainIM, train.getX(), train.getY(), this);
		g.drawImage(zooIM, zooX, zooY,this);
		//train.getTA().add(new Animal());
		for (int i=0; i<train.getTA().size(); i++){
		    if (train.getLeft()){ // change to tailArray.get(i).getIM(); both left and right
				g.drawImage(train.getTA().get(i).getIM(), train.getTA().get(i).getX(), train.getTA().get(i).getY(), this);
		    }
		    else{
				g.drawImage(train.getTA().get(i).getIM(), train.getTA().get(i).getX(), train.getTA().get(i).getY(), this);
		    }
		}
		if (aBroom == true){
			g.drawImage(trashIM, broom.getX(), broom.getY(), this);
		}
		if (aNet == true){
			g.drawImage(netIM, net.getX(), net.getY(), this);
		}
		Toolkit.getDefaultToolkit().sync();
	    }
	} // showIcons
		
	void gameLogic(){//void gameLogic(int pauseDelay) throws InterruptedException {
	    if(gameover == false && pause == false) {
			// checks if train crosses paths with zoo and clears tailArray
			if ((zooX - zWidth/2) < train.getX() && (train.getX() < (zooX + zWidth/2)) 
				&& (train.getY() > zooY - zHeight/2) && (train.getY() < zooY + zHeight/2)){
			   int n = train.getTA().size();
			   train.getTA().clear();
			   train.incShift();
			   total += n;
			   score += n;
			   
			   // if all animals are collected
				if (numAnimals == total){ 
					animalArray.clear();
					trashArray.clear();
					total = 0;
					numAnimals+=5;
					numTrash+=2;
					for(int i = 0; i < numAnimals; i++) {
						addNewBoardAnimal();
					}
					for(int i = 0; i < numTrash; i++) {
						addNewTrash();
					}
				}
			}
				
			// checks if train crosses paths with tail & stops game
			for(int i = 0; i < train.getTA().size(); i++) {
				if(train.getX() == train.getTA().get(i).getX() && train.getY() == train.getTA().get(i).getY()) {
					gameover = true;
				}
			}
			
			// checks if train crosses paths with animals
			for(int i = 0; i < animalArray.size(); i++) {					
				if ((animalArray.get(i).getX() - pWidth/2) < train.getX() && (train.getX() < (animalArray.get(i).getX() + pWidth/2)) 
				&& (train.getY() > animalArray.get(i).getY() - pHeight/2) && (train.getY() < animalArray.get(i).getY() + pHeight/2)){						
					if (!animalArray.get(i).isDead()){
						animalArray.get(i).setURL();
						animalArray.get(i).setDead();
						animalArray.get(i).getIM();
						total++;
						score--;
					}
				} // endif
			}
		
			// check if net crosses path with animal - clear animal
			for(int i = 0; i < animalArray.size(); i++) {					
				if ((animalArray.get(i).getX() - pWidth/2) < net.getX() && (net.getX() < (animalArray.get(i).getX() + pWidth/2)) 
				&& (net.getY() > animalArray.get(i).getY() - pHeight/2) && (net.getY() < animalArray.get(i).getY() + pHeight/2)){						
					if (!animalArray.get(i).isDead()){
						// animalArray.get(i).setX(2000);
// 						animalArray.get(i).setY(2000);
						score++;
						int n = train.getTA().size();
						addNewTailAnimal(animalArray.get(i)); // change animal type
						if (n==0){
							train.getTA().get(n).setX(train.getX());
							train.getTA().get(n).setY(train.getY());
						}
						else{
							train.getTA().get(n).setX(train.getTA().get(n-1).getX());
							train.getTA().get(n).setY(train.getTA().get(n-1).getY());
						}
					}
				}
			}
		
			// check if broom crosses path with poo - clear poo
			for(int i = 0; i < trashArray.size(); i++) {					
				if ((trashArray.get(i).getX() - pWidth/2) < broom.getX() && (broom.getX() < (trashArray.get(i).getX() + pWidth/2)) 
				&& (broom.getY() > trashArray.get(i).getY() - pHeight/2) && (broom.getY() < trashArray.get(i).getY() + pHeight/2)){						
					trashArray.get(i).setX(2000);
					trashArray.get(i).setY(2000);
					score++;
				}
			}
		
			// checks if train crosses paths with poo
			for(int i = 0; i < trashArray.size(); i++) {					
				if ((trashArray.get(i).getX() - pWidth/2) < train.getX() && (train.getX() < (trashArray.get(i).getX() + pWidth/2)) 
				&& (train.getY() > trashArray.get(i).getY() - pHeight/2) && (train.getY() < trashArray.get(i).getY() + pHeight/2)){						
					gameover = true;
				} // endif
			}
				
	
		
			// checks if train goes beyond screen boundaries & stops gameif(train.getX() > maxGridX || train.getX() < 0 ||
			if(train.getX() > maxX || train.getX() < 0 || train.getY() > maxY || train.getY() < 0) {
				gameover = true;
			}
	    }
	    if(gameover == true) {
            	timer.stop();
	    }
	} // end gameLogic

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (gameover == false && pause == false) {
			gameLogic();
			train.move();
			if (aBroom == true && nBroom >= 0)
				broom.move();
			if (aNet == true && nNet >= 0)
				net.move();
	    }
	    repaint();
	}
	/**
	   Class to handle keyboard events to move train on screen
	   up, down, left, or right based on user input, maybe put this in game env
	*/
	public class Keyboard extends KeyAdapter {
	    @Override
	    public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			if((key == KeyEvent.VK_LEFT) && (!train.getRight())){
				URL trainURL = getClass().getResource("graphics/tleft.png");
				trainIM = new ImageIcon(trainURL).getImage();
				train.setLeft();
			}
			if((key == KeyEvent.VK_RIGHT) && (!train.getLeft())){
				URL trainURL = getClass().getResource("graphics/tright.png");
				trainIM = new ImageIcon(trainURL).getImage();
				train.setRight();
			}
			if((key == KeyEvent.VK_UP) && (!train.getDown())){
				URL trainURL = getClass().getResource("graphics/tup.png");
				trainIM = new ImageIcon(trainURL).getImage();
				train.setUp();
			}
			if((key == KeyEvent.VK_DOWN) && (!train.getUp())){
				URL trainURL = getClass().getResource("graphics/tdown.png");
				trainIM = new ImageIcon(trainURL).getImage();
				train.setDown();
			}
			if (key == KeyEvent.VK_SPACE && nBroom > 0){
				broom.setXY(train.getX(), train.getY());
				aBroom = true;
				nBroom--;
				broom.setDirection(train);
			}
			if (key == KeyEvent.VK_C && nNet > 0){
				net.setXY(train.getX(), train.getY());
				aNet = true;
				nNet--;
				net.setDirection(train);
			}
			if (key == KeyEvent.VK_ESCAPE && pause == false){
				GameMenu game = new GameMenu();
				game.makeMenu();
				pause = true;
			}
			if (key == KeyEvent.VK_ESCAPE && pause == true){
				pause = false;
			}
	    } // keyPressed
	} // Keyboard
    } // end DrawingPanel

    /**
       Class to display game menu with options to play game,
       read instructions, and exit the game
    */
    class GameMenu implements ActionListener {
		JButton Pause = new JButton("Pause");
		/* 
		   import buttons if desired
		   implement save if desired
		   JButton Save = new JButton "Save & Exit"*/
		
		JButton Exit = new JButton("Exit");
		
		
			// Start GUI for game environment with menu
			public void makeMenu() {
				Pause.addActionListener(this);
				// Save.addActionListener(this);
				Exit.addActionListener(this);
			
				JPanel gameButtons = new JPanel(new BorderLayout());
				animationFrame.getContentPane().add(BorderLayout.SOUTH, gameButtons);
				gameButtons.add(BorderLayout.EAST, Pause);
				// gameButtons.add(BorderLayout.CENTER, Save);
				gameButtons.add(BorderLayout.WEST, Exit);
	
				//gameButtons.setContentAreaFilled( false );

				animationFrame.setVisible(true);
        }
        
        // Performs actions if buttons are pressed
    	@Override
		public void actionPerformed(ActionEvent buttonPress) {
			if(buttonPress.getSource() == Exit) {
				System.exit(0);
			}
		} 
    }
}
