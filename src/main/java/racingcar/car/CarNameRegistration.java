package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.model.CarName;
import racingcar.utils.ErrorMessage;
import racingcar.utils.StringValidator;

@Deprecated
public class CarNameRegistration {

	private static final int MIN_CAR_NAME_LENGTH = 2;
	private static final String DELIMITER = ",";

	private List<CarName> carNameList;

	public CarNameRegistration(String inputCarNames) throws IllegalArgumentException {
		if (StringValidator.isBlank(inputCarNames)) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_BLANK);
		}
		String[] splitCarName = inputCarNames.split(DELIMITER);
		validateCarListLength(splitCarName);
		addCarToNameList(splitCarName);
	}

	private void validateCarListLength(String[] splitCarName) throws IllegalArgumentException {
		if (splitCarName.length < MIN_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.MINIMUM_CAR_NEEDED);
		}
	}

	private void addCarToNameList(String[] splitCarName) throws IllegalArgumentException {
		carNameList = new ArrayList<>();
		for (String carName : splitCarName) {
			carNameList.add(new CarName(carName));
		}
	}


	public List<CarName> getCarNameList() {
		return carNameList;
	}


}
