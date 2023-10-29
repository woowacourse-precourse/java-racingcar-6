package racingcar;

import java.util.ArrayList;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;

public class GameProcess {

	public GameProcess() {

	}

	public void playGame(ArrayList<InformationOfCar> carList, int moveCount) {
		for (InformationOfCar car : carList) {
			for (int j = 0; j < moveCount; j++) {
				moveOrNot(car);
				//진행상황 출력
			}
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
