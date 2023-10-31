package racingcar.service;

import static racingcar.utility.RandomNumberGenerator.*;
import static racingcar.utility.constant.NumberConstant.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.GameRepository;

public class GameService {
	private final GameRepository gameRepository;

	public GameService() {
		gameRepository = new GameRepository();
	}

	public void createGame(List<Car> cars) {
		gameRepository.saveGame(cars);
	}

	public List<Car> findAll() {
		return gameRepository.findAll();
	}

	public void playRound() {
		List<Car> forwardCars = new ArrayList<>();
		List<Car> cars = gameRepository.findAll();
		for (Car car : cars) {
			if (isForward()) {
				forwardCars.add(car);
			}
		}
		gameRepository.moveForward(forwardCars);
	}

	public boolean isForward() {
		return getRandomNumber() >= FORWARD_POINT.getValue();
	}

	public List<String> getWinners() {
		Long maxPosition = gameRepository.getMaxForwardPosition();
		List<String> winners = new ArrayList<>();
		List<Car> cars = gameRepository.findAll();
		for (Car car : cars) {
			if (car.getForwardCount().equals(maxPosition)) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}
