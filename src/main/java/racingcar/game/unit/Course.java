package racingcar.game.unit;

import java.util.List;
import racingcar.game.message.ErrorMessage;

public class Course {

	private int attempt;

	public static Course of(int attempt) {
		if (attempt < 0) {
			throw new IllegalArgumentException(
					ErrorMessage.ATTEMPT_NOT_LESS_THAN_0.getMessage());
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
