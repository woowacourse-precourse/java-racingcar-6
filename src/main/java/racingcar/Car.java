package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

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
		return generatedRandomNumber() >= 4;
	}

	protected int generatedRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

}
