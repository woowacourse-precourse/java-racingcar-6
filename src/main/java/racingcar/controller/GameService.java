package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.GameRecord;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final int NUMBER_RANGE_START = 0;
    private static final int NUMBER_RANGE_END = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final int MIN_VALUE = -1;
    private final GameRecord gameRecord = new GameRecord();

    public void play(Game game) {
        moveByRandomNumber(game);
        game.increaseTrialNum();
    }

    public List<String> getWinners(Game game) {
        List<Cars> cars = game.getCars();
        int maxPosition = getPosition(cars);
        return getPositionCars(cars, maxPosition);
    }

    public Boolean isEnd(Game game) {
        return gameRecord.isEnd(game);
    }

    public Long save(Game game) {
        return gameRecord.save(game);
    }

    private List<String> getPositionCars(List<Cars> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Cars car : cars) {
            if (car.getPosition() == maxPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private int getPosition(List<Cars> cars) {
        int max = MIN_VALUE;
        for (Cars car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private void moveByRandomNumber(Game game) {
        for (Cars cars : game.getCars()) {
            if (FORWARD_CONDITION <= getRandomNumber()) {
                cars.moveForward(1);
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
