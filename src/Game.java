import java.util.Random;

public class Game {
	private Player player1;
	private Player player2;
	private Random die;
	private Spinner spinner;
	//private final String LOSER_SPIN = "grunt";
	// The loser_spin should have been GRUNT since that is the way the string is stored and displayed
	private final String LOSER_SPIN = "GRUNT";
	private final int LOSER_ROLL = 1;
	
	public Game(){
//		Player player1 = new GUIPlayer();
//		Player player2 = new ComputerPlayer();
        // player1 and player 2 had already been defined as being from the Player class.
		// Thus, do not need to define them again and can just set the variables equal to the desired value.
		
		player1 = new GUIPlayer();
		player2 = new ComputerPlayer();
		die = new Random();
		spinner = new Spinner();
	}
	
	/*
	 * Method will play one game between the players.
	 */
	public void playGame(){
		printStartGameMessage();
		Player whoseTurn = player1;
		while(!winner()){
			int roundScore = takeATurn(whoseTurn);
			whoseTurn.addToScore(roundScore);
			// Switch whose turn it is.
			if(whoseTurn == player1){
				whoseTurn = player2;
			}
			else{
				whoseTurn = player1;
			}
		}
		printEndGameMessage();
	}
	
	/*
	 * One player's turn.  Ends because
	 * - roll a 1
	 * - spin a "GRUNT"
	 * - or Player decides to stop
	 * 
	 * Return the number of points to add to the player
	 */
	public int takeATurn(Player whoseTurn){
		int roundScore = 0;
		boolean keepGoing = true;
		printStartRoundMessage(whoseTurn);
		while(keepGoing){
			// int roll = die.nextInt(7);
			// The nextInt command choose a random integer between 0 (inclusive) and the input (exclusive)
			// Thus, we need to set the bound to 6 so that we get a value between 0 and 5
			// Then, we add 1 to the result so that the number is between 1 and 6
			int roll = die.nextInt(6) + 1;
			String spin = spinner.spin();
			System.out.println(roll+ " "+ spin);
			
//			if(roll == LOSER_ROLL){
//				System.out.println("Lose a turn.");
//					return 0;
//			}
			// Before returning a value, checks to see if spin equals GRUNT
			// If so, then resets the score
			// Otherwise, ends the turn
			
			
			if(roll == LOSER_ROLL){
				System.out.println("Lose a turn.");
				if(spin == LOSER_SPIN.toUpperCase()) {
					System.out.println("Too bad!  Lose all your points.");
					whoseTurn.resetScore();
				}
					return 0;
			}
			else if(spin == LOSER_SPIN.toUpperCase()){
				System.out.println("Too bad!  Lose all your points.");
				whoseTurn.resetScore();
				return 0;
			}
			else{
				roundScore = roundScore + roll;
				System.out.println("Round total is currently: "+roundScore);
				keepGoing = whoseTurn.rollAgain(roundScore);
			}
		}
		return roundScore;
	}
	
	// True if one of the players has won the game.
	public boolean winner(){
		//return player1.hasWon() && player2.hasWon();
		// The game is won if one of the players reaches the needed score and is not played until both players win.
		// Thus, the statement logical operator should be a || instead of an &&.
		return player1.hasWon() || player2.hasWon();
	}
	
	/* 
	 * These methods are for printing messages to the console to follow the game.
	 */
	public void printStartRoundMessage(Player whoseTurn){
		System.out.println("New Round!  "+ whoseTurn.getName()+" 's turn."); 
		System.out.println(player1);
		System.out.println(player2);
	}
	
	public void printEndGameMessage(){
		if(player1.hasWon()){
			System.out.println("Winner is "+player1.getName());
		}
		else{
			System.out.println("Winner is "+player2.getName());
		}
	}
	
	public void printStartGameMessage(){
		System.out.println("Let's Play Pig!");
	}
}
