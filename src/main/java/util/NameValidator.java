package util;

import racingcar.CarConstants;

public class NameValidator {

        public static boolean isValidInput(String input) {
            String[] names = input.split(",");
            for (String name : names) {
                if (name.trim().isEmpty())
                    return false;
                if(!isValidLength(name))
                    return false;
                if(!isAlphabet(name))
                    return false;
            }
            return true;
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
}