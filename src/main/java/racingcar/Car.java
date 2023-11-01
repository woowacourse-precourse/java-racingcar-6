package racingcar;

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

	public void setScore(int score) {
		this.score = score;
	}

	public boolean canMove(int number) {
		return number >= 4;
	}

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