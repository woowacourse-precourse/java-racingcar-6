package racingcar.service;

import racingcar.util.PickRandomNumber;

import static racingcar.type.PlayType.MOVING_POSSIBILITY;

public class ShiftGear {
    public static boolean moveForward() {
        return PickRandomNumber.generate() >= MOVING_POSSIBILITY.getPlayValue();
    }
}
