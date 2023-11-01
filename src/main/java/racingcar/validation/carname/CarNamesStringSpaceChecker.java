package racingcar.validation.carname;

public class CarNamesStringSpaceChecker {

	private static final String Space = " ";

	public void checkCarNamesWithSpaceChecker(String carNamesString) {
		if (carNamesString.contains(Space)) {
			throw new IllegalArgumentException();
		}
	}
}
