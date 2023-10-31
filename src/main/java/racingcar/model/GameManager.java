package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void tryMoveCar(Car car) {
        if (makeRandomNumber() > 4) {
            car.moveCar();
        }
    }
}
