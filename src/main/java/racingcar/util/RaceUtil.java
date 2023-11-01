package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class RaceUtil {
    public static int raceNumber(String moveTime) {
        return RaceValidate.checkRaceNumber(moveTime);
    }
}
