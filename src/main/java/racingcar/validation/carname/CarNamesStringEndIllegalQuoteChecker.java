package racingcar.validation.carname;

public class CarNamesStringEndIllegalQuoteChecker {

	private static final String SplitingPoint = ",";

	public void checkCarNamesStringEndIllegalQuote(String carNamesString) {
		if (carNamesString.endsWith(SplitingPoint)) {
			throw new IllegalArgumentException();
		}
	}
}
