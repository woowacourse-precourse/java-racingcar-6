package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class GameProcess {

	private final PrintGenerator printGenerator;

	public GameProcess(PrintGenerator printGenerator) {
		this.printGenerator = printGenerator;
	}

	public void playGame(ArrayList<InformationOfCar> carList, int moveCount) {
		System.out.println("실행 결과");
		for (int j = 0; j < moveCount; j++) {
			for (InformationOfCar car : carList) {
				moveOrNot(car);
				printGenerator.printMoveResult(car);
			}
			System.out.println();
		}
	}

	private void moveOrNot(InformationOfCar car) {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (judgeMoveOrNot(randomNumber)) {
			car.setDistance("-");
		}
	}

	private boolean judgeMoveOrNot(int randomNumber) {
		return randomNumber >= 4;
	}

}
