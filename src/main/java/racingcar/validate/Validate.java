package racingcar.validate;

import racingcar.constant.CarRaceConstant;

public class Validate {

    private Validate() {
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void carNameLength(String input) {
        String[] parts = input.split(",");
        if (parts.length > CarRaceConstant.MAX_NAME_LENGTH.getConstant()) {
            throw new IllegalArgumentException();
        }
    }


}
