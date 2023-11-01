package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.input.InputController;
import racingcar.validation.carname.CarNamesValidationChecker;

public class CarListMaker {

	InputController inputController = new InputController();
	CarNamesValidationChecker carNamesValidationChecker = new CarNamesValidationChecker();
	private static final Integer InitialStartingStep = 0;
	private static final String SplitingPoint = ",";

	public List<Car> makeCarList() {
		List<Car> carList = new ArrayList<Car>();
		String carNamesString = inputController.scanCarNames();
		try {
			carNamesValidationChecker.checkCarNamesValidation(carNamesString);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw illegalArgumentException;
		}
		for (String carName : List.of(carNamesString.split(SplitingPoint))) {
			carList.add(new Car(carName, InitialStartingStep));
		}
		return carList;
	}
}
