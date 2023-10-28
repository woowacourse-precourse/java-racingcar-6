package racingcar;

import java.util.ArrayList;

public class EntryPoint {

	private ArrayList<InformationOfCar> carList;
	private final UserInput userInput;

	public EntryPoint() {
		this.carList = new ArrayList<InformationOfCar>();
		this.userInput = new UserInput(carList);
	}

	public void startGame() {
		carList = userInput.inputInformationOfCar();
		int moveCount = userInput.inputMoveCount();
	}
}
