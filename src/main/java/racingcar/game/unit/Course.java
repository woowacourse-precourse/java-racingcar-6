package racingcar.game.unit;

import java.util.List;

public class Course {

	private int attempt;

	public static Course of(int attempt) {
		if (attempt < 0) {
			throw new IllegalArgumentException("시도 횟수는 0 이상이어야 합니다.");
		}
		return new Course(attempt);
	}

	private Course(int attempt) {
		this.attempt = attempt;
	}

	public void racingStart(List<Car> cars, Referee referee) {
		referee.announceRacingStart();
		for (int i = 0; i < attempt; i++) {
			cars.forEach(Car::startEngine);
			referee.broadcast(cars);
		}
	}
}
