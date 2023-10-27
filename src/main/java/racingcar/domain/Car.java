package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrStop() {
        if (isMove()) {

        }
    }

    private boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }
}
