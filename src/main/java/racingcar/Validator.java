package racingcar;

import static racingcar.RacingConst.CAR_NAME_SIZE;

public class Validator {

    public static Boolean isNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static Boolean isNotCarName(String input) {
        return input.length() > CAR_NAME_SIZE;
    }
}
