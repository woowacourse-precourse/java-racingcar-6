package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RaceGame {
	private List<Pair> carsInformation;
	private int trial;
	
	protected List<Pair> getNamesInput(){
		GamePrint.printGetNames();
		String namesInput = GameInput.getNames();
		
		return GameInput.parseNames(namesInput);
	}
	
	protected int getTrialInput() {
		GamePrint.printGetTrial();
		
		return GameInput.getTrial();
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
	
	protected List<String> getWinner(List<Pair> carsInformation) {
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
		carsInformation = getNamesInput();
		trial = getTrialInput();
		
		GamePrint.printStart();
		race();
		
		GamePrint.printWinner(getWinner(this.carsInformation));
	}
}