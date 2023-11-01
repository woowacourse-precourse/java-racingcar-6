package racingcar;

public record Car(String playerName) {

	public Car {
		if (playerName.length() > 5) {
			throw new IllegalArgumentException("사용자의 이름은 5글자 이하여야 합니다.");
		}
	}
}
