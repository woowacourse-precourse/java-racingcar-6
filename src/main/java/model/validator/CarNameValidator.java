package model.validator;

import exception.ErrorMessage;

import java.util.List;
import racingcar.Constants;
import racingcar.Util;

public class CarNameValidator {
	private final String carNames;
	public final List<String> nameList;

	public CarNameValidator(String carNames) {
		this.carNames = carNames;
		this.nameList = Util.toList(carNames);
		validate();
	}

	public void validate() {
		validateCarNames();
		validateCarNameSize();
		validateDuplicate();
	}

	public void validateCarNames() {
		if (!Constants.namesStringPattern.matcher(carNames).matches()) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_CAR_NAME);
		}
	}

	public void validateCarNameSize() {
		if (nameList.stream().anyMatch(name -> name.isEmpty() || name.length() > Constants.NAME_SIZE)) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_NAME_SIZE);
		}
	}

	public void validateDuplicate() {
		if (nameList.size() != nameList.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME);
		}
	}
}
