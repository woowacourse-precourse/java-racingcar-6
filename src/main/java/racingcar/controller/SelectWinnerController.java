package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;

public class SelectWinnerController {

	public List<Car> resultCars(Car[] cars) {
	    int max = findMaxForwardCount(cars);
	    List<Car> winnerCars = new ArrayList<Car>();
	    for (Car car : cars) {
	        if (car.getForwardCount() == max) {
	            winnerCars.add(car);
	        }
	    }
	    return winnerCars;
	}

	private int findMaxForwardCount(Car[] cars) {
	    int max = 0;
	    for (Car car : cars) {
	        if (car.getForwardCount() > max) {
	            max = car.getForwardCount();
	        }
	    }
	    return max;
	}
	
}
