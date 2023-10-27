package racingcar.service;

import java.util.List;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.dto.CarDTO;
import racingcar.dto.CarListDTO;
import racingcar.dto.RoundDTO;

public class Game {
	List<CarDTO> carList;
	RoundDTO round;
	
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
		round = new RoundDTO();
		round.setRound(roundNumber);
	}
	
	public void startGame() {
		//Output.printStartGame();
		//Output.printRound(null, 0);
		
	}
	
	public void endGame() {
		// Output.printResult(null, 0);
	}
}