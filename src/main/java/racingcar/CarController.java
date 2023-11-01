package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarController {

    int random;

    public String moveOrStop(Car car) {
        makeRandomNumber();

        if (car.move(random)) {
            return "Move";
        }
        return "Stop";
    }

    private void makeRandomNumber() {
        random = Randoms.pickNumberInRange(0, 9);
    }
}
