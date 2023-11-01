package racingcar.model;

import racingcar.model.Cars;

import java.util.List;

public class Game {
	private final int trial;
	private final List<Cars> cars;
	private int trialNum = 0;

	public Game(List<Cars> cars, int trial) {
		this.cars = cars;
		this.trial = trial;
	}

	public List<Cars> getCars() {
		return cars;
	}

	public void increaseTrialNum() {
		this.trialNum += 1;
	}

	public Boolean checkReachTrialNumToTrial() {
		return this.trial == this.trialNum;
	}
}
