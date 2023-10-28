package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CreateCarsService {

	public Cars createCars(String inputValue) {
		String[] carNames = inputValue.split(",");
		List<Car> carList = new ArrayList<>();

		for (String carName : carNames) {
			carList.add(createCar(carName));
		}

		return new Cars(carList);
	}

	private Car createCar(String carName) {
		return new Car(carName);
	}
}
