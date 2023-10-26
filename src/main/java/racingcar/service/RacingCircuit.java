package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarGarage;

public class RacingCircuit {

    public void race(CarGarage garage) {
        for (Car car : garage.cars()) {
            boolean isGo = checkRacingCondition();
            if (isGo) {
                car.goForward();
            }
        }
    }

    private boolean checkRacingCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
