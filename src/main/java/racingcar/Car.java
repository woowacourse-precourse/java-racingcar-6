package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private static final int VALUE = 4;
	private static final int MIN = 0;
	private static final int MAX = 9;

	private final Name name;
	private final Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public String getName() {
		return name.toString();
	}

	public int getPosition() {
		return position.getPosition();
	}

	public void move() {
		position.move();
	}

	public void stopOrMove() {
		if (canMove()) {
			move();
		}
	}

	private boolean canMove() {
		return generatedRandomNumber() >= VALUE;
	}

	protected int generatedRandomNumber() {
		return Randoms.pickNumberInRange(MIN, MAX);
	}

}
