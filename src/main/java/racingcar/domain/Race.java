package racingcar.domain;

import static racingcar.constant.Constant.MOVE_LOWER_BOUND;
import static racingcar.constant.Constant.RANDOM_NUMBER_MAX;
import static racingcar.constant.Constant.RANDOM_NUMBER_MIN;
import static racingcar.constant.Constant.ZERO;
import static racingcar.constant.ExceptionMessage.NO_WINNER_MESSAGE;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {

    private Map<String, Car> playCars;

    public Race(Map<String, Car> playCars) {
        this.playCars = playCars;
    }

    public void start() {
        playCars.forEach((car, distance) -> decideMoveOrStay(car));
    }

    private void decideMoveOrStay(String carName) {
        int randomNumber = getRandomNumber();
        if (isAvailableMove(randomNumber)) {
            go(carName);
        }
    }

    private void go(String carName) {
        playCars.get(carName).moving();
    }

    private boolean isAvailableMove(int randomNumber) {
        return randomNumber >= MOVE_LOWER_BOUND;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public List<String> getWinner() {
        return findWinner();
    }

    public List<String> findWinner() {
        Integer longestDistance = getLongestDistance();
        validateWinner(longestDistance);
        return playCars.entrySet().stream()
                .filter(car -> car.getValue().getMoveDistance().equals(longestDistance))
                .map(Entry::getKey)
                .toList();
    }

    private void validateWinner(Integer longestDistance) {
        if (longestDistance==ZERO) {
            throw new IllegalArgumentException(NO_WINNER_MESSAGE.getMessage());
        }
    }

    private Integer getLongestDistance() {
        return playCars.values().stream()
                .map(car -> car.getMoveDistance())
                .max(Integer::compareTo).get();
    }

}
