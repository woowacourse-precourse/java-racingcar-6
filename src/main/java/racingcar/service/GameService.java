package racingcar.service;

import static racingcar.utility.RandomNumberGenerator.*;
import static racingcar.utility.constant.NumberConstant.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.dto.GameDto;
import racingcar.repository.GameRepository;

public class GameService {
	private final GameRepository gameRepository;

	public GameService() {
		gameRepository = new GameRepository();
	}

	public void createGame(GameDto gameDto) {
		gameRepository.saveGame(gameDto);
	}

	public void playGame(Long roundCount) {
		while (roundCount-- > 0) {
			playRound();
		}
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
}
