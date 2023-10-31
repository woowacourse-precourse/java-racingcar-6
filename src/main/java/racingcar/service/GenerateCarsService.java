package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.InputNameException;
import racingcar.util.StringAndListParser;

public class GenerateCarsService {
	private InputNameException nameException = new InputNameException();
	private StringAndListParser parser = new StringAndListParser();
	private String[] nameArray;

	public void generateCars(String names, Cars cars) {
		getNames(names);
		for (int i = 0; i< nameArray.length; i++) {
			cars.setCars(new Car(nameArray[i]));
		}
	}

	public String[] setCarArray(String names) {
		return nameArray = parser.splitString(names);
	}

	public void getNames(String names) {
		nameException.checkException(setCarArray(names));
	}
}