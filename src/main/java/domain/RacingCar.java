package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingCar {
	private final List<Car> cars = new ArrayList<>();

	public RacingCar(List<String> nameList) {
		for (String name : nameList) {
			Car car = new Car(name);
			this.cars.add(car);
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public int findLocationWithMostMovement() {
		List<Car> sortedCars = new ArrayList<>(this.cars);
		sortCarsByLocation(sortedCars);
		Car carWithMostMovement = sortedCars.get(0);
		return carWithMostMovement.getLocation();
	}

	public void sortCarsByLocation(List<Car> sortedCars) {
		Collections.sort(sortedCars, Collections.reverseOrder(Comparator.comparingInt(Car::getLocation)));
	}

	public List<Car> findCarWithMaxLocation(int maxLocation) {
		List<Car> winners = new ArrayList<>();
		for (Car car : this.cars) {
			if (car.getLocation() == maxLocation) {
				winners.add(car);
			}
		}
		return winners;
	}
}
