package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.util.StringAndListParser;

public class DecideWinnerService {
	private StringAndListParser parser = new StringAndListParser();
	private int maxLength = 0;
	private String winner;
	private List<String> winnerList = new ArrayList<>();

	public void compareMax(int length) {
		if (isMax(length)) {
			maxLength = length;
		}
	}

	public void addWinner(List<Car> cars, int index) {
		if (isWinner(cars, index)) {
			winnerList.add(cars.get(index).getName());
		}
	}

	public void setWinnerList(List<Car> cars) {
		getMax(cars);
		for (int i = 0; i < cars.size(); i++) {
			addWinner(cars, i);
		}
	}

	public void getMax(List<Car> cars) {
		for (int i = 0; i < cars.size(); i++) {
			compareMax(cars.get(i).getDistance().length());
		}
	}

	public List<String> getWinner(List<Car> cars) {
		setWinnerList(cars);
		return winnerList;
	}

	public String getResult(List<Car> cars) {
		winner = parser.parseToString(getWinner(cars));
		return winner;
	}

	private boolean isMax(int length) {
		return maxLength < length;
	}

	public boolean isWinner(List<Car> cars, int index) {
		return cars.get(index).getDistance().length() == maxLength;
	}
}