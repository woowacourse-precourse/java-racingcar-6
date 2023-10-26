package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

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
        return Randoms.pickNumberInRange(0, 9) > 4;
    }

}
