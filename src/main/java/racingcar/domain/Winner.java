package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
	private List<Car> winnerList;

	public List<Car> findWinner(List<Car> carList) {
		List<Car> sortedList = sortByPositionDescending(new ArrayList(carList));
		return winnerList = getWinnerCarList(sortedList);
	}

	public List<Car> getWinner() {
		return winnerList;
	}

	private List<Car> sortByPositionDescending(List<Car> carList) {
		carList.sort(Comparator.comparingInt(Car::getPosition).reversed());
		return carList;
	}

	private List<Car> getWinnerCarList(List<Car> sortedList) {
		Integer winnerPosition = sortedList.get(0).getPosition();
		return sortedList.stream()
			.filter(car -> winnerPosition.equals(car.getPosition()))
			.collect(Collectors.toList());
	}
}
