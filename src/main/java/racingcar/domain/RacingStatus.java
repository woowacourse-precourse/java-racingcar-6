package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	public List<String> findMaxValueFromCarStatus() {
		List<String> maxKeys = new ArrayList<>();
		int maxValue = Integer.MIN_VALUE;

		roofFindMaxValue(maxKeys, maxValue);

		return maxKeys;
	}

	private void roofFindMaxValue(List<String> maxKeys, int maxValue) {
		for (Map.Entry<String, Integer> entry : this.carStatus.entrySet()) {
			int value = entry.getValue();
			maxValue = getMaxValue(maxKeys, maxValue, entry, value);
		}
	}

	private static int getMaxValue(List<String> maxKeys, int maxValue, Entry<String, Integer> entry,
		int value) {
		if (value > maxValue) {
			maxKeys.clear();
			maxKeys.add(entry.getKey());
			maxValue = value;
		} else if (value == maxValue) {
			maxKeys.add(entry.getKey());
		}
		return maxValue;
	}
}
