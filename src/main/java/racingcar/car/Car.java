package racingcar.car;

import static camp.nextstep.edu.missionutils.Randoms.*;

import racingcar.util.Validator;

public class Car {
	private String name;
	private int moveCount;
	private static final int MOVE_CONDITION = 3;

	public Car(String name) {
		this.name = name;
		this.moveCount = 0;
		Validator.carNameLength(name);
		Validator.onlyWhiteSpace(name);
	}

	public boolean decideMoveOrNot() {
		int decide = pickNumberInRange(0, 9);
		return (decide > MOVE_CONDITION);
	}

	public void move() {
		this.moveCount++;
	}

	public String getName() {
		return name;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void printMoveResult() {
		System.out.print(this.getName());
		System.out.print(" : ");
		for (int i = 0; i < this.moveCount; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
