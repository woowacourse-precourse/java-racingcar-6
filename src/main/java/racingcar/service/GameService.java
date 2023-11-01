package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final GameRepository gameRepository = new GameRepository();

    public void playGame(Game game) {
        moveByRandomNumber(game);
        game.increaseCount();
    }

    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int winnerPosition = maxPosition(cars);
        return maxPositionCarNames(cars, winnerPosition);
    }

    private void moveByRandomNumber(Game game) {
        for (Car car : game.getCars()) {
            if (getRandomNumber() >= 4) {
                car.move(1);
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> maxPositionCarNames(List<Car> cars, int maxPosition) {
        List<String> maxCarNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                maxCarNames.add(car.getName());
            }
        }
        return maxCarNames;
    }

    public Boolean isGameEnd(Game game) {
        return gameRepository.checkGameEnd(game);
    }

    public Long saveGame(Game game) {
        return gameRepository.save(game);
    }
}
