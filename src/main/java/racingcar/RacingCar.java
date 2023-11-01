package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class RacingCar {
	private final String name;
	private int position;

	private static final int RANDOM_NUMBER_CHECK = 4;

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
		if (randomNumber >= RANDOM_NUMBER_CHECK) {
			position++;
		}
	}

//	public int generateRandomNumber() {
//		return Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
//	}

	public void printProgress() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++)
			System.out.print("-");
		System.out.println();
	}
}
