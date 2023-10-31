//Game.java
package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.View.InputValidator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Game {
	RacingCars racingCars;
	int roundCount;

	public void run(){
		this.racingCars = new RacingCars(getRacingCars());
		this.roundCount = getRoundCount();

		OutputView.printRoundStart();
		for(int i = 0; i < roundCount; i++){
			racingCars.runRound();
		}

		List<Car> winners = racingCars.findWinner();
		OutputView.printWinner(racingCars.getCarNames(winners));
	}

	private List<Car> getRacingCars(){
		String input = InputView.getCarNamesInput();
		InputValidator.validateCarNamesInput(input);
		String[] carNamesArr =  input.split(",");

		List<Car> racingCars = new ArrayList<>();
		for(String carName : carNamesArr){
			racingCars.add(new Car(carName));
		}
		return racingCars;
	}
	private int getRoundCount(){
		String input = InputView.getRoundCountInput();
		InputValidator.validateRoundCountInput(input);
		return Integer.parseInt(input);
	}
}
