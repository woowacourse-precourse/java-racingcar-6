package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class RacingStatus {

	private Map<String, Integer> carStatus = new HashMap<>();

	private int tryNumber;

	public RacingStatus (String carNames, String tryNumber) {
		String[] carNameArray = carNames.split(",");
		createCarStatus(carNameArray);
		this.tryNumber = Integer.parseInt(tryNumber);
	}

	public void updateCarStatus() {
		for (String carName : this.carStatus.keySet()) {
			int randomNumber = Randoms.pickNumberInRange(0,9);
			resetCarStatus(carName, randomNumber);
		}
	}

	private void createCarStatus(String[] carNameArray) {
		for (String carName : carNameArray) {
			this.carStatus.put(carName, 0);
		}
	}

	private void resetCarStatus(String carName, int randomNumber) {
		if (randomNumber >= 4) {
			int currentValue = this.carStatus.get(carName);
			this.carStatus.put(carName, currentValue + 1);
		}
	}

	public Map<String, Integer> getCarStatus() {
		return carStatus;
	}

	public int getTryNumber() {
		return tryNumber;
	}
}
