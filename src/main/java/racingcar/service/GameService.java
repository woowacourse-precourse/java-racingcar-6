package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.GameRepository;
import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.SystemConstant.*;

public class GameService {

    private static final GameRepository gameRepository = new GameRepository();

    public void play(Game game) {
        moveForwardByRandomNumber(game);
        game.increaseTrialNumber();
    }

    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);
        return getMaxPositionCars(cars, maxPosition);
    }

    private List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private int getMaxPosition(List<Car> cars) {
        for (Car car : cars) {
            if (MAX < car.getPosition()) {
                MAX = car.getPosition();
            }
        }
        return MAX;
    }

    private void moveForwardByRandomNumber(Game game) {
        for (Car car : game.getCars()) {
            if (FORWARD_CONDITION <= RandomUtil.getRandomNumbers()) {
                car.moveForward(1);
            }
        }
    }

    public void save(Game game) {
        gameRepository.save(game);
    }

    public boolean isEnd(Game game) {
        return gameRepository.isEnd(game);
    }
}
