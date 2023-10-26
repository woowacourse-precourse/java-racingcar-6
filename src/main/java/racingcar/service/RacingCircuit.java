package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCircuit {

    public void race(List<Car> cars) {
        for (Car car : cars) {
            boolean isGo = checkRacingCondition();
            if (isGo) {
                car.goForward();
            }
        }
    }

    private boolean checkRacingCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<Car> findWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(it -> it.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > max) {
                max = position;
            }
        }
        return max;
    }
}
