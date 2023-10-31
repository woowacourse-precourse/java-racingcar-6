package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingcarGame {
    private static final int COUNT_ONE = 1;
    private static final int CRITERION_FOUR = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER_ = 9;

    public List<String> createWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int max = findMaxMoveForwardCount(cars);
        for (Car car : cars) {
            if (car.getMoveForwardCount() == max) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }

    private int findMaxMoveForwardCount(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getMoveForwardCount() > max) {
                max = car.getMoveForwardCount();
            }
        }
        return max;
    }

    public void increaseMoveForwardCount(Car car) {
        if (isGreaterThanOrEqualFour()) {
            car.setMoveForwardCount(COUNT_ONE);
        }
    }

    private boolean isGreaterThanOrEqualFour() {
        return generateRandomNumber() >= CRITERION_FOUR;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER_);
    }
}
