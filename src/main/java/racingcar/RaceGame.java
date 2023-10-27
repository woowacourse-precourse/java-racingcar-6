package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

class RaceGame {
	private List<Pair> carsInformation;
	private int trial;
	
	private void getInput() {
		GamePrint.printGetNames();
		String namesInput = GameInput.getNames();
		carsInformation = GameInput.parseNames(namesInput);
		
		GamePrint.printGetTrial();
		trial = GameInput.getTrial();
	}
	
	private boolean moveForward() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) return true;
		return false;
	}
	
	private void doSingleTrial() {
		for (int i = 0; i < carsInformation.size(); i++) {
			if (moveForward() == true) {
				carsInformation.get(i).move();
			}
		}
	}
	
	private void race() {
		for (int i = 0; i < trial; i++) {
			doSingleTrial();
			GamePrint.printRace(carsInformation);
		}
	}

	protected void playGame() {
		getInput();
		GamePrint.printStart();
		race();
	}
}