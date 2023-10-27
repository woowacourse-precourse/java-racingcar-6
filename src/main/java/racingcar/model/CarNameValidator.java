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
		if (!isRightNamesString()) {
			throw new IllegalArgumentException("Validation failed.");
		}
	}

	public boolean isRightNamesString() {
		return Constants.namesStringPattern.matcher(carInput).matches();
	}
}
