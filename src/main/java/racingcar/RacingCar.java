package racingcar;

import static racingcar.Properties.END_INCLUSIVE;
import static racingcar.Properties.MOVEMENT_SYMBOL;
import static racingcar.Properties.MOVEMENT_THRESHOLD;
import static racingcar.Properties.START_INCLUSIVE;
import static racingcar.Properties.ZERO;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int position = ZERO;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public boolean isMovable() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVEMENT_THRESHOLD;
    }

    @Override
    public String toString() {
        return name + " : " + MOVEMENT_SYMBOL.repeat(position);
    }
}
