package racingcar.model;

import static racingcar.constant.Constant.Four;
import static racingcar.constant.Constant.NINE;
import static racingcar.constant.Constant.ZERO;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private StringBuilder distance;


    public Car(String name) {
        this.name = name;
        this.distance = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public StringBuilder getDistance() {
        return distance;
    }

    public void move() {
        if (canMove()) {
            distance.append("-");
        }
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(ZERO.number, NINE.number);
        if (randomNumber >= Four.number) {
            return true;
        }
        return false;
    }
}
