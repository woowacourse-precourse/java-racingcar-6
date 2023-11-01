package util;

import racingcar.CarConstants;

public class NameValidator {

        public static void isValidInput(String input) {
            String[] names = input.split(",");
            for (String name : names) {
                if (name.isEmpty())
                    throw new IllegalArgumentException(CarConstants.INVALID_INPUT_MESSAGE+"trim");
                if(!isValidLength(name))
                    throw new IllegalArgumentException(CarConstants.INVALID_INPUT_LENGTH_ERROR_MESSAGE);
                if(!isAlphabet(name))
                   throw new IllegalArgumentException(CarConstants.INVALID_INPUT_MESSAGE);
            }

        }
    public static boolean isValidLength(String name) {
        if(name.length() > CarConstants.MAX_NAME_LENGTH)
            return false;
        if(name.length() < CarConstants.MIN_NAME_LENGTH)
            return false;

        return true;
    }

    public static boolean isAlphabet(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}