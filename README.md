# SnakeTrain (Potentially renamed to ZooWrangler)

##Building the Game
-----------------
Once the project is downloaded, you can build the game by using ANT commands to create the jar file and run the game with one of the following commands:
* ant run	Runs the game starting at the game's menu screen
* ant run-jar   Runs the game from the created jar file
* ant run-game	Runs the game starting at the game's first level                   

The main libraries we use are java standard libraries including but not limited to Swing, Event, and Util libraries

Note: The GUI frames can been bigger on certain OS's (Windows, Linux) in comparision to Mac


The Game begins with a menu screen that has the following options: New Game, Instructions, Exit

##New Game
--------
* The player can start a new game that begins at the first level by clicking the "New Game" button

##Instructions
------------
* The "Instructions" button opens up a window with the premise and rules for the game

##Exit
----
* The "Exit" button closes the game and ends the session


To build the program properly, the user must be careful not to move the files around and keep it so that the java files are located in the 'src' directory, the class files get sent to the 'build' directory, and the graphics are in the 'graphics' directory


##Bugs
* There is a bug correlating to the panel size of our window. While the user can stretch the frame to a larger size, the boarder that the train interacts with isn't visible and doesn't extend, so it can crash unexpectedly.
* Instead of animal picture appearing in the tail of the train, a penguin appears.
* The game over splash screen doesn't pop up when the train crashes so there is no way to restart the game without completely exiting and reinitializing the game again.


##How to Play
* Open the menu and start a new game
* Use the 'up', 'down', 'right', and 'left' keys to control the train
* Avoid running into poop or walls, results in game over
* Cross paths with animals to pick them up and add them to your tail
* Cross paths with the zoo to drop off any tail animals
* Use the 'space bar' to throw brooms and sweep away the poop
* Use the 'esc' key to pull up the 'pause' and 'exit' menu buttons


Link to the GitHub: https://github.com/jazariethach/ZooScum