package racingcar.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.view.ErrorMessage;

public class InputValidator {
    public void isValidCarName(String inputStr) {
        if(isNull(inputStr)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL.getMessage());
        }
        if (isTooLongString(inputStr)) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LONG.getMessage());
        }
        if (hasSameName(inputStr)) {
            throw new IllegalArgumentException(ErrorMessage.SAME_NAME.getMessage());
        }
        if (hasSpace(inputStr)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_SPACE.getMessage());
        }
    }

    public void isValidAttemptNum(String inputStr) {
        if(isNull(inputStr)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL.getMessage());
        }
        if(!isNumber(inputStr)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private boolean isNumber(String inputStr) {
        return inputStr != null && inputStr.matches("[0-9]+");
    }

    private boolean isNull (String inputStr) {
        return inputStr == null || inputStr.equals("") || inputStr.equals("\n");
    }
    private boolean isTooLongString (String inputStr) {
        String[] inputStringArray = inputStr.split(",");
        for(String str : inputStringArray) {
            if (str.length() > 5) {
                return true;
            }
        }
        return false;
    }
    private boolean hasSameName (String inputStr) {
        String[] inputStringArray = inputStr.split(",");
        Set<String> nameSet = new HashSet<>(Arrays.asList(inputStringArray));

        if(nameSet.size() != inputStringArray.length) {
            return true;
        }
        return false;
    }

    private boolean hasSpace (String inputStr) {
        char[] inputArr = inputStr.toCharArray();
        for (char input: inputArr) {
            if (input == ' ') {
                return true;
            }
        }
        return false;
    }

}
