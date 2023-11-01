package racingcar.model;

public class Lap {
	private final Cars cars;
	private final Round round;

	public Lap(Cars cars, Round round) {
		this.cars = cars;
		this.round = round;
	}

	public RaceStatus getRaceStatus() {
		cars.moveForward();
		round.proceedRound();

		return new RaceStatus(cars.getCars());
	}

	public RaceStatus getWinner() {
		return new RaceStatus(cars.getFirstPlaceCars());
	}

	public boolean isGameEnd() {
		return round.isEndRound();
	}
}
