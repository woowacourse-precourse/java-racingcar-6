package racingcar.support.round;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Position;

public class RoundResult {

	private final Map<CarName, Position> results;

	private RoundResult(Map<CarName, Position> results) {
		this.results = results;
	}

	public static RoundResult generate(Cars cars) {
		Map<CarName, Position> results = new LinkedHashMap<>();

		for (Car car : cars.getCars()) {
			results.put(car.getCarName(), car.getPosition());
		}

		return new RoundResult(results);
	}

	public Map<CarName, Position> getResults() {
		return results;
	}
}
