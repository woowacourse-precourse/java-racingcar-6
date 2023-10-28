package racingcar;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

	private final Validator validator;

	public UserInput() {
		this.validator = new Validator();
	}

	public ArrayList<InformationOfCar> inputInformainOfCar(ArrayList<InformationOfCar> carList) {
		StringTokenizer nameDivider = new StringTokenizer(Console.readLine(), ",");
		return addToCarList(nameDivider, carList);
	}

	private ArrayList<InformationOfCar> addToCarList(StringTokenizer nameDivider, ArrayList<InformationOfCar> carList) {
		while (nameDivider.hasMoreTokens()) {
			String carName = nameDivider.nextToken();
			if (validator.validateNameLength(carName)) {
				carList.add(new InformationOfCar(carName, ""));
			}
		}
		return carList;
	}
}
