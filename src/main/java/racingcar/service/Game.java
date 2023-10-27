package racingcar.service;

import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.domain.Car;
import racingcar.domain.Round;

public class Game {
	Car car;
	Round round;
	
	public void setGame() {
		car = new Car();
		round = new Round();
		String[] cars = Input.requestCarName();
		Input.requestRoundNumber(round);
	}
	
	public void startGame() {
		//Output.printStartGame();
		//Output.printRound(null, 0);
		
	}
	
	public void endGame() {
		// Output.printResult(null, 0);
	}
}