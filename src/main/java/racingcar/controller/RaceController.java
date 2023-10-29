package racingcar.controller;

import racingcar.model.RaceStatus;
import racingcar.model.Cars;
import racingcar.model.Round;

public class RaceController {
	private final Cars cars;
	private final Round round;

	public RaceController(Cars cars, Round round) {
		this.cars = cars;
		this.round = round;
	}

	public RaceStatus getRaceStatus() {
		cars.moveForward();
		round.proceedRound();
		return new RaceStatus(cars.getCars());
	}

	public RaceStatus getFinalRaceStatus() {
		while (!round.isEndRound()) {
			getRaceStatus();
		}
		return new RaceStatus(cars.getFirstPlaceCars());
	}

	public boolean isEndRace() {
		return round.isEndRound();
	}
}
