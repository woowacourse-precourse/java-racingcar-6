package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.GameRepository;

public class GameService {
    private static final int START_POSITION = 0;
    private static final int END_POSITION = 9;
    private static final int MIN_VALUE = -1;
    private final GameRepository gameRepository = new GameRepository();
    public void Fowardstart(Game game){
        moveForwardByRandomNumber(game);
        game.incresePlayCount();
    }

    public Boolean isEnd(Game game) {
        return gameRepository.isEnd(game);
    }

    public Long save(Game game) {
        return gameRepository.save(game);
    }

    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = getWinnerPosition(cars);
        return getWinnerPositionCars(cars, maxPosition);
    }

    private List<String> getWinnerPositionCars(List<Car> cars, int winnerPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private int getWinnerPosition(List<Car> cars) {
        int max = MIN_VALUE;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private void moveForwardByRandomNumber(Game game) {
        for (Car car : game.getCars()) {
            if (START_POSITION <= getRandomDistance()) {
                car.moveFoward(1);
            }
        }
    }

    private int getRandomDistance() {
        return Randoms.pickNumberInRange(START_POSITION, END_POSITION);
    }
}
