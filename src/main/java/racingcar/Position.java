package racingcar;

public class Position {

	private static final int INITIAL_POSITION = 0;

	private int position;

	public Position() {
		this.position = INITIAL_POSITION;
	}

	public void move() {
		position++;
	}

	public int getPosition() {
		return position;
	}

}
