package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class RacingCar {
	private final String name;
	private int position;

	public RacingCar(final String name) {
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void move(int randomNumber) {
		if (randomNumber >= 4) {
			position++;
		}
	}

	public int generateRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

	public void printProgress() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++)
			System.out.print("-");
		System.out.println();
	}
}
