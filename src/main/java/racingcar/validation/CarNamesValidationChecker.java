package racingcar.validation;

import java.util.List;
import racingcar.validation.carname.CarNamesDuplicationChecker;
import racingcar.validation.carname.CarNamesLengthValidationChecker;
import racingcar.validation.carname.CarNamesStringEndIllegalQuoteChecker;
import racingcar.validation.carname.CarNamesStringSpaceChecker;

public class CarNamesValidationChecker {

	CarNamesStringEndIllegalQuoteChecker carNamesStringEndIllegalQuoteChecker = new CarNamesStringEndIllegalQuoteChecker();
	CarNamesLengthValidationChecker carNamesLengthValidationChecker = new CarNamesLengthValidationChecker();
	CarNamesStringSpaceChecker carNamesStringSpaceChecker = new CarNamesStringSpaceChecker();
	CarNamesDuplicationChecker carNamesDuplicationChecker = new CarNamesDuplicationChecker();
	private static final String SplitingPoint = ",";

	public void checkCarNamesValidation(String carNamesString) {
		List<String> carNamesList = List.of(carNamesString.split(SplitingPoint));
		try {
			carNamesStringEndIllegalQuoteChecker.checkCarNamesStringEndIllegalQuote(carNamesString);
			carNamesStringSpaceChecker.checkCarNamesWithSpaceChecker(carNamesString);
			carNamesLengthValidationChecker.checkCarNamesLengthValidation(carNamesList);
			carNamesDuplicationChecker.checkCarNamesDuplicationChecker(carNamesList);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw illegalArgumentException;
		}
	}
}
