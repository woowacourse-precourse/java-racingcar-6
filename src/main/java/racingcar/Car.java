package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car
{
	public final String Name;
	private int Score;

	public String getName() {
		return Name;
	}

	public int getScore() {
		return Score;
	}

	public Car(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Name = name;
		Score = 0;
	}

	public boolean canMove() {
		int num = Randoms.pickNumberInRange(0,9);
		return num >= 4;
	}



	public void move(boolean canMove) {
		if (canMove) {
			Score++;
		}
	}

	public String display() {
		String result = Name + " : ";
		if (Score > 0) {
			result += "-".repeat(Score);
		}
		return result;
	}
}