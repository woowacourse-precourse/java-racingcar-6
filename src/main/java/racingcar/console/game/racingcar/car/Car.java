package racingcar.console.game.racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.console.game.racingcar.constants.GameConstants.*;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void operate() {
        if ( Randoms.pickNumberInRange(START_RANGE, END_RANGE) > MOVE_RANGE) {
            location += 1;
        }
    }

    public void indicateLocation() {
        System.out.println(name + DELIMITER + INDICATOR.repeat(location));
    }

    public String getName() {
        return name;
    }
    public int getLocation() {
        return location;
    }
}
