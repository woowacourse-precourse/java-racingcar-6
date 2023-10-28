package racingcar;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

	private ArrayList<InformationOfCar> carList;
	private final Validator validator;

	public UserInput(ArrayList<InformationOfCar> carList) {
		this.carList = carList;
		this.validator = new Validator();
	}

	public ArrayList<InformationOfCar> inputInformationOfCar() {
		StringTokenizer nameDivider = new StringTokenizer(Console.readLine(), ",");
		return addToCarList(nameDivider);
	}

	private ArrayList<InformationOfCar> addToCarList(StringTokenizer nameDivider) {
		while (nameDivider.hasMoreTokens()) {
			String carName = nameDivider.nextToken();
			if (validator.validateNameLength(carName)) {
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
