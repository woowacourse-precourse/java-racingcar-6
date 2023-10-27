package racingcar;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

	public UserInput() {

	}

	public ArrayList<InformationOfCar> inputInformainOfCar(ArrayList<InformationOfCar> carList) {
		StringTokenizer nameDivider = new StringTokenizer(Console.readLine(), ",");

		while (nameDivider.hasMoreTokens()) {
			String carName = nameDivider.nextToken();
			//검증 파트
			carList.add(new InformationOfCar(carName, ""));
		}
		return carList;
	}
}
