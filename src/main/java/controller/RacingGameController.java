package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.Car;

public class RacingGameController {

	public int findLocationWithMostMovement(List<Car> cars) {
		List<Car> sortedCars = new ArrayList<>(cars);
		sortCarsByLocation(sortedCars);
		Car carWithMostMovement = sortedCars.get(0);
		return carWithMostMovement.getLocation();
	}

	public void sortCarsByLocation(List<Car> sortedCars) {
		Collections.sort(sortedCars, Collections.reverseOrder(Comparator.comparingInt(Car::getLocation)));
	}

	public List<Car> findCarWithMaxLocation(List<Car> cars, int maxLocation) {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getLocation() == maxLocation) {
				winners.add(car);
			}
		}
		return winners;
	}
}
