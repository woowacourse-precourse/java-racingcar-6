package racingcar.controller;
import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
public class SelectWinnerController {

	
	public List<Car> resultCars(Car[]cars){
		int max = 0;
		List<Car> winnerCars = new ArrayList<Car>();
		for(int i = 0;i<cars.length;i++) {
			if(moreThanMax(max,cars[i])) {
				winnerCarSet(winnerCars, cars[i]);
			}
		}
		return winnerCars;
	}
	
	private boolean moreThanMax(int max, Car car) {
		
		if(car.getForwardCount()>max)
			return true;
		return false;
	}
	
	private void winnerCarSet(List<Car>cars, Car car) {
		cars.clear();
		cars.add(car);
	}
}
