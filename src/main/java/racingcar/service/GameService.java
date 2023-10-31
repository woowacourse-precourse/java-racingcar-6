package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class GameService {
	public List<Car> going(List<Car> cars) {
		return cars.stream()
				   .map(car -> {
					   if (Randoms.pickNumberInRange(0, 9) >= 4) {
						   return new Car(car.name, car.distance + 1);
					   }
					   
					   return car;
				   })
				   .toList();
	}

	public List<Car> getWinners(List<Car> cars) {
		int maxDistance = cars.stream()
							  .mapToInt(car -> car.distance)
							  .max()
							  .orElse(0);

		return cars.stream()
				   .filter(car -> car.distance == maxDistance)
				   .toList();
	}
}