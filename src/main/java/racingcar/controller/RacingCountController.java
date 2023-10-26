package racingcar.controller;

import racingcar.util.Validation;

public class RacingCountController {
    public static int makeRacingCount(String InputRacingCount) {
        Validation.valiRacingCount(InputRacingCount);
        return convertToInt(InputRacingCount);
    }

    private static int convertToInt(String InputRacingCount) {
        return Integer.parseInt(InputRacingCount);
    }
}
