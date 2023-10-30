package racingcar.game;

import java.util.List;
import racingcar.game.unit.Course;
import racingcar.game.unit.Garage;
import racingcar.game.unit.Car;
import racingcar.game.unit.Referee;

public class RacingGame {

	private Garage garage;
	private Referee referee;

	public static RacingGame newRacingGame() {
		return new RacingGame(
				Garage.newGarage(),
				Referee.newReferee());
	}

	private RacingGame(
			Garage garage,
			Referee referee) {
		this.garage = garage;
		this.referee = referee;
	}

	public void play() {
		List<Car> cars = garage.publishCars();
		Course course = referee.selectCourse();
		course.racingStart(cars, referee);
		referee.announceWinner(cars);
	}
}