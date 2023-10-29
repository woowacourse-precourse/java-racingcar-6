package racingcar;

import java.util.ArrayList;

public class EntryPoint {

	private ArrayList<InformationOfCar> carList;
	private final UserInput userInput;
	private final PrintGenerator printGenerator;
	private final GameProcess gameProcess;

	public EntryPoint() {
		this.carList = new ArrayList<InformationOfCar>();
		this.userInput = new UserInput(carList);
		this.printGenerator = new PrintGenerator();
		this.gameProcess = new GameProcess(printGenerator);
	}

	public void startGame() {
		printGenerator.printNameQuestion();
		carList = userInput.inputInformationOfCar();
		printGenerator.printCountQuestion();
		int moveCount = userInput.inputMoveCount();
		gameProcess.playGame(carList, moveCount);
	}
}
