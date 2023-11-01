package racingcar;

import java.util.ArrayList;
import java.util.List;

//게임 시작 클래스
public class EntryPoint {

	private List<InformationOfCar> carList;
	private final UserInput userInput;
	private final GameProcess gameProcess;

	public EntryPoint() {
		this.carList = new ArrayList<InformationOfCar>();
		this.userInput = new UserInput(carList);
		this.gameProcess = new GameProcess();
	}

	public void startGame() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		carList = userInput.inputInformationOfCar();
		System.out.println("시도할 회수는 몇회인가요?");
		int moveCount = userInput.inputMoveCount();
		gameProcess.playGame(carList, moveCount);
	}
}
