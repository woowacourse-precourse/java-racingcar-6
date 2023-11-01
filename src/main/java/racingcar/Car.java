package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car
{
	// 이름은 한번 생성자가 생성 될 때 한번 입력 받고 변경하지 않아 상수로 둠
	public final String name;
	private int score;

	public Car(String name) {
		this.name = name;
		score = 0;
	}

	public int getScore() {
		return score;
	}

	/**
	 * camp.nextstep.edu.missionutils.Randoms를 사용해 랜덤한 숫자를 뽑고 전진할 수 있는지 여부 판단
	 * @return
	 */
	public boolean canMove(int number) {
		return number >= 4;
	}

	/**
	 * 전진 할 수 있다면 Score++
	 * @param canMove
	 */
	public void move(boolean canMove) {
		if (canMove) {
			score++;
		}
	}

	/**
	 * score만큼 "-" 붙여서 전진했다는 표시를 해줌
	 * @return
	 */
	public String display() {
		String result = name + " : ";
		result += "-".repeat(score);
		return result;
	}

}