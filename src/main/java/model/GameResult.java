package model;

import static racingcar.Util.getMax;

import java.util.List;
import java.util.stream.Collectors;
import model.mapper.CarMapper;

public class GameResult {
    private final List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

	public List<String> getWinnerNames() {
		List<Car> winners = getWinningCars();
		return CarMapper.mapToCarNames(winners);
	}

	private List<Car> getWinningCars() {
		int maxPosition = getMax(getPositions());
		return cars.stream()
				.filter(car -> car.isWinner(maxPosition))
				.collect(Collectors.toList());
	}


	private List<Integer> getPositions() {
		return cars.stream()
				.map(Car::getPosition)
				.collect(Collectors.toList());
	}
}
