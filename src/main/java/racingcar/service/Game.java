package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.dto.CarListDTO;
import racingcar.domain.Car;
import racingcar.domain.Round;

public class Game {
	List<Car> carList;
	Round round;
	
	public void setGame() {
		generateCarList();
		generateRound();
	}
	
	private void generateCarList() {
		String[] carStringArray = Input.requestCarName();
		CarListDTO carListDTO = new CarListDTO();
		carList = carListDTO.makeCarList(carStringArray);
	}
	
	private void generateRound() {
		int roundNumber = Input.requestRoundNumber();
		System.out.println(roundNumber);
	}
	
	public void startGame() {
		//Output.printStartGame();
		//Output.printRound(null, 0);
		
	}
	
	public void endGame() {
		// Output.printResult(null, 0);
	}
}