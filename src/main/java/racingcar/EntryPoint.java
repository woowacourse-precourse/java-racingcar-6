package racingcar;

import java.util.ArrayList;

public class EntryPoint {

	private ArrayList<InformationOfCar> carList;
	private final UserInput userInput;
	private final GameProcess gameProcess;

	public EntryPoint() {
		this.carList = new ArrayList<InformationOfCar>();
		this.userInput = new UserInput(carList);
		this.gameProcess = new GameProcess();
	}

	public void startGame() {
		carList = userInput.inputInformationOfCar();
		int moveCount = userInput.inputMoveCount();
		gameProcess.playGame(carList, moveCount);
	}
}
