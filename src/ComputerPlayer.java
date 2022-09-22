
public class ComputerPlayer extends Player{
	private final int MIN_POINTS = 15;
	
	public ComputerPlayer(){
		//super("R2D2");
		// The cause of the error was that the name was never defined in the constructor and 
		// was only used to set the score. My set myName = "R2D2" like in GUIPlayer
		super("R2D2");
		myName = "R2D2";
	}

	@Override
	/*
	 *Computer will stop rolling if:
	 *	- It doesn't have 15 points yet (or MIN_POINTS)
	 *	- Stopping will win the game.
	 */
	public boolean rollAgain(int totalSoFar) {
		return (myScore + totalSoFar)<100 && totalSoFar < MIN_POINTS;
	}
}
