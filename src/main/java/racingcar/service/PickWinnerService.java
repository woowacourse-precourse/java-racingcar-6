package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class PickWinnerService {
	
	public List<Car> pickWinner(Cars cars) {
		int maxCarLocation = getMaxCarLocation(cars);
		List<Car> winnerList = new ArrayList();
		
		for(Car car : cars.getCars()) {
			if(car.getCarLocation() == maxCarLocation) {
				winnerList.add(car);
			}
		}
		
		return winnerList;
	}
	
	public String printWinner(List<Car> carList) {
		StringJoiner strJoiner = new StringJoiner(", ");
		
		for(Car car : carList) {
			strJoiner.add(car.getCarName());
		}
		
		return strJoiner.toString();
	}
	
	private int getMaxCarLocation(Cars cars) {
		return cars.getCars().stream()
						.mapToInt(Car::getCarLocation)
						.max()
						.getAsInt();
	}
}
