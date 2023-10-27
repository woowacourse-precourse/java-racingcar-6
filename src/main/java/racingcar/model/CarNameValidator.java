package racingcar.model;

import racingcar.Constants;
import racingcar.Util;

import java.util.ArrayList;

public class CarNameValidator {
	private final String carInput;
	public final ArrayList<String> carNameList;

	public CarNameValidator(String carInput) {
		this.carInput = carInput;
		this.carNameList = Util.strToList(carInput);
		validate();
	}

	public void validate() {
		if (!isRightNamesString() || !isRightNameSize() ) {
			throw new IllegalArgumentException("Car Validation failed.");
		}
	}

	public boolean isRightNamesString() {
		return Constants.namesStringPattern.matcher(carInput).matches();
	}

	public boolean isRightNameSize() {
		return carNameList.stream()
				.allMatch(name -> !name.isEmpty() && name.length() <= Constants.NAME_SIZE);
	}
}
