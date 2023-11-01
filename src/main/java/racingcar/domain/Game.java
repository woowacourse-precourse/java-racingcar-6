package racingcar.domain;

import java.util.List;

public class Game {
	private final int trial; //총 시도수
	private final List<Car> cars;
	private int trialCount = 0; //현재 회차

	public Game(List<Car> cars, int trial) {
		this.cars = cars;
		this.trial = trial;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void increaseTrialNumber() {
		this.trialCount += 1;
	}


	public Boolean checkTrialEqualsToTrialCount() {
		return this.trial == this.trialCount;
	}
}