package racingcar.service;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CreateCarsService {

	public Cars createCars(String inputValue) {
		String[] carNames = inputValue.split(",");
		
		return new Cars(convertStringArrToCarList(carNames));
	}
	
	private List<Car> convertStringArrToCarList(String[] strArr){
		return Arrays.stream(strArr)
						.map(this::createCar)
						.toList();
	}
	
	private Car createCar(String carName) {
		return new Car(carName);
	}
}
