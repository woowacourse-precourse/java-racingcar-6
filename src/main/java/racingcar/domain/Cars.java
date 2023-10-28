package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public String printCarsStatus() {
		StringJoiner strJoiner = new StringJoiner(System.lineSeparator());

		for (Car car : cars) {
			strJoiner.add(car.printCarStatus());
		}
		
		strJoiner.add(" ");
		
		return strJoiner.toString();
	}
	
	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
