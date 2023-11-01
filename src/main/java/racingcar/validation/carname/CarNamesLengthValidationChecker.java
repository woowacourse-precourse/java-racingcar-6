package racingcar.validation.carname;

import java.util.List;

public class CarNamesLengthValidationChecker {

	private static final Integer minimunLengthLimit = 1;
	private static final Integer maximunLengthLimit = 5;
	private static final Integer indexSteps = 1;
	private Integer index = 0;

	public void checkCarNamesLengthValidation(List<String> carNamesList) {
		if (index == carNamesList.size()) {
			return;
		}
		if (carNamesList.get(index).length() < minimunLengthLimit
			|| carNamesList.get(index).length() > maximunLengthLimit) {
			throw new IllegalArgumentException();
		}
		index = index + indexSteps;
		checkCarNamesLengthValidation(carNamesList);
	}
}
