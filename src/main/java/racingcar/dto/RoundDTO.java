package racingcar.dto;

import racingcar.domain.Round;

public class RoundDTO {
	Round round;
	
	public Round makeRound(int roundNumber) {
		round = new Round(roundNumber);
		return round;
	}
}