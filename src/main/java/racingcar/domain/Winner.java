package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	private List<String> winner = new ArrayList<>();

	public void setWinner(String carName) {
		winner.add(carName);
	}

	public List<String> getWinner() {
		return winner;
	}
}
