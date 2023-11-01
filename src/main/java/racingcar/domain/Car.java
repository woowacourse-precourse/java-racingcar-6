package racingcar.domain;

import static racingcar.controller.RaceController.LOGGERNAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.logging.Logger;

public class Car {

    private static final int MOVING_FORWARD = 4;
    String name;
    int moved;

    public Car(String name) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.moved = 0;
        Logger log = Logger.getLogger(LOGGERNAME);
        log.info(this.toString());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : "
                + "-".repeat(moved);
    }

    boolean validateName(String name) {
        return name.length() != 0 && name.length() <= 5;
    }


    public void move() {
        if (Randoms.pickNumberInRange(0,9) >= MOVING_FORWARD) {
            moved ++;
        }
    }
}
