//Player class for storing player info
public class Player {
	private int score = 0;
	public String name;
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public void setScore() {
		score = 0;
	}
}
