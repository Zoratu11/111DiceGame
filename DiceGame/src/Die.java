import java.util.concurrent.ThreadLocalRandom;

public class Die {
	int randNum;
	int sides = 6;
	public void roll(){
		randNum = ThreadLocalRandom.current().nextInt(1, sides + 1);
		//nextInt() isn't doesn't include the last number so I added 1 so it would
	}
}
