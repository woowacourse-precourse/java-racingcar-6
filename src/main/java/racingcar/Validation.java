package racingcar;

import java.util.Arrays;

public class Validation {
    private static final int PLAYER_NAME_LENGTH = 5;


    public static boolean isCarNameInputValid(String input) {
        if (isContainConsecutiveComma(input)) {
            return false;
        }
        String[] carNames = input.split(",");
        return Arrays.stream(carNames)
                .allMatch(Validation::isCarNameInputValid);
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isContainConsecutiveComma(String input) {
        int inputLength = input.length();
        for (int i = 0; i < inputLength - 1; i++) {
            if (input.charAt(i) == ',' && input.charAt(i + 1) == ',') {
                return true;
            }
        }
        return false;
    }


        private static boolean isValidLengthName(String input) {
            return input.length() <= PLAYER_NAME_LENGTH;
        }
}
