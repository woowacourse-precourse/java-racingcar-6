package racingcar.dto;

import racingcar.domain.Round;

public class RoundDTO {
	Round round = new Round();
	
	public void setRound(int roundNumber) {
		round.setRoundNumber(roundNumber);
	}
	
	public int getRoundNumber() {
		return round.getRoundNumber();
	}
}