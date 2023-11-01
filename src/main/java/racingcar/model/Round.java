package racingcar.model;

public class Round {
	private int round;

	public Round(int round) {
		this.round = round;
	}

	public void proceedRound() {
		round--;
	}

	public boolean isEndRound() {
		return round <= 0;
	}
}
