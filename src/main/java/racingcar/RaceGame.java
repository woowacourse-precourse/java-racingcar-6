package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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
	
	private List<String> getWinner() {
		Collections.sort(carsInformation);
		List<String> winners = new ArrayList<String>();
		
		int maxNumber = carsInformation.get(0).getLocation();
		
		for (int i = 0; i < carsInformation.size(); i++) {
			int location = carsInformation.get(i).getLocation();
			String name = carsInformation.get(i).getName();
			
			if (location == maxNumber) {
				winners.add(name);
			}
		}
		
		return winners;
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
		GamePrint.printWinner(getWinner());
	}
}