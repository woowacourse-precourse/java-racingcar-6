package racingcar.model.validate;

import racingcar.model.constant.CarRaceConstant;

public class Validate {

    private Validate() {}

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void carNameLength(String input) {
        String[] parts = input.split(",");
        for (String part : parts) {
            if (part.length() > CarRaceConstant.MAX_NAME_LENGTH.getConstant()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isNotNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }
}