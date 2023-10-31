package racingcar.service;

import racingcar.util.PickRandomNumber;

public class ShiftGear {
    public static boolean moveForward() {
        return PickRandomNumber.generate() >= 4;
    }
}
