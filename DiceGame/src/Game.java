/*
 * Author: Chris Goodburn
 */
import java.util.InputMismatchException;
import java.util.Scanner;
//This is the game logic class it does pretty much everything for this game
public class Game extends Die {
	boolean playing;
	int numOfPlayers;
	public Player[] players = new Player[4];
	int roundNum = 1;//Number of round corresponds to the player number 
	//Ex: player 1 would be playing in round 1 player 2 in round 2
	Scanner scan = new Scanner(System.in);
	int roundScore;
	

	
	public void startGame() {
		
		System.out.println("Welcome to the game 111.\n" +
		"The rules are simple, each player has to try to reach the\n" +
		"score 111 by rolling dice. The first person there wins but\n" +
		"if you roll a 1 your turn ends and your score is reset to 0 for the round.\n" +
		"You can roll as many times as you want. You type yes if you want to\n" +
		"roll and no if you want to stop rolling.\n" + "Have fun!!\n" + 
		"(4 Players max) \n");
		//Rules and how to play the game
		
		System.out.print("How many people are playing?");
		try{
		numOfPlayers = scan.nextInt();
		} catch (InputMismatchException e)
		{
			System.out.println("Sorry try again, you can only enter numbers 1 through 4!!");
			scan.nextLine();
			startGame();
		}
		if(numOfPlayers > 4) {
			System.out.println("Can't have more than 4 players");
			startGame();
		}
		for(int i = 0; i < numOfPlayers; i++) {
			players[i] = new Player();
			players[i].name = "Player" + i;
		}//This for loop fills the Player array with actual Player objects and also names them
		playing = true;
		playGame();
		
	}
	
	public void scoreHandler() {//This method handles the score
		roll();
		roundScore += randNum;
		if(randNum == 1) {//Checks if die roll is ever 1 and if it is its a new round and
			//the player that rolled 1 gets their score set to 0
			playing = false;
			roundScore = 0;
		}
		for(int h = 0; h < numOfPlayers; h++) {
			if(players[h].getScore() >= 111) {
				System.out.println("Congratulations, " + players[h].name +
						" you won!!");
			}
		}
		System.out.println("The total score for this round is: " + roundScore);
	}
	
	public void playGame() {//This method is the actual game
		playing = true;
		while(playing) {//The whole game is just a big loop
			String yesOrNo;
			System.out.println("Player " + (roundNum) + ", will you roll?");
			yesOrNo = scan.next();
			yesOrNo.toLowerCase();
			if(yesOrNo.equals("no")) {
				playing = false;
			} else if(yesOrNo.equals("yes")){
				scoreHandler();
			}
		}
		players[roundNum - 1].addScore(roundScore);
		System.out.println("Player " + (roundNum) + " Score: " + players[roundNum - 1].getScore());
		roundScore = 0;
		roundNum++;
		if(roundNum > numOfPlayers) {
			roundNum = 1;
		}//After round is over either go back to the first player or keep going then start the
		//game again
		if(playing == false) {
			playGame();
		}
	}
}
