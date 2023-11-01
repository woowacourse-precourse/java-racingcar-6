package racingcar;

import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

//사용자 입력 클래스
public class UserInput {

	private List<InformationOfCar> carList;
	private final Validator validator;

	public UserInput(List<InformationOfCar> carList) {
		this.carList = carList;
		this.validator = new Validator();
	}

	public List<InformationOfCar> inputInformationOfCar() {
		StringTokenizer nameDivider = new StringTokenizer(Console.readLine(), ",");
		carList = addToCarList(nameDivider);
		return carList;
	}

	private List<InformationOfCar> addToCarList(StringTokenizer nameDivider) {
		validator.validateEmptyString(nameDivider.hasMoreTokens());
		while (nameDivider.hasMoreTokens()) {
			String carName = nameDivider.nextToken();
			if (validator.validateNameLength(carName) && validator.validateSpace(carName)) {
				carList.add(new InformationOfCar(carName, ""));
			}

		}
		return carList;
	}

	public int inputMoveCount() {
		String moveCountString = Console.readLine();
		return validator.validateMoveCount(moveCountString);
	}
}
