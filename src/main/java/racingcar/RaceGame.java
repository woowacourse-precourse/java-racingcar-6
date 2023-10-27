package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

class RaceGame {
	private List<String> carNames;
	private int trial;
	
	private void getInput() {
		GamePrint.printGetNames();
		String namesInput = GameInput.getNames();
		carNames = GameInput.parseNames(namesInput);
		
		GamePrint.printGetTrial();
		trial = GameInput.getTrial();
	}

	protected void playGame() {
		getInput();
	}
}