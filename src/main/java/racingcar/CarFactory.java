package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
	public List<Car> makeCarListUse(String name){
		List<Car> cars = new ArrayList<>();
		String[] nameArr = name.split(",");
		for (String s : nameArr) {
			cars.add(new Car(s));
		}
		return cars;
	}
}
