package racingcar;

import java.util.List;

import racingcar.View.OutputView;

public class Game {
	Round round;
	List<Car> racingCars;
	int roundCount;
	public void run(){
		setRacingCars();
		setRoundCount();
		for(int i = 0; i < roundCount; i++){
			round.runRound(racingCars);
		}
		Car winner = findWinner();
		OutputView.printWinner(winner);

	}

	private void setRacingCars(){}

	private void setRoundCount(){}

	private Car findWinner(){
		Car winner = new Car();
		return winner;
	}
}
