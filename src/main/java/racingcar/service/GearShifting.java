package racingcar.service;

import racingcar.util.PickRandomNumber;

public class GearShifting {
    public static boolean moveForward() {
        return PickRandomNumber.generate() >= 4;
    }
}
