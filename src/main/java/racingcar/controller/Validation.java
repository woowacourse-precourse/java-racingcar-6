package racingcar.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final Pattern LOWERCASE_AND_COMMA = Pattern.compile("^[a-z,]*[a-z]$");

    /**
     * 입력된 자동차 데이터 유효성 검사
     * @param inputCarName
     * @return true || false
     */
    public boolean validationNames(String inputCarName) {
        String[] carNames = inputCarName.split(",");

        if (!checkCharacter(inputCarName)) {
            return false;
        }
        if (!checkCharacterNumber(carNames)) {
            return false;
        }
        return true;
    }

    private boolean checkCharacter(String inputCarName) {
        Matcher matcher = LOWERCASE_AND_COMMA.matcher(inputCarName);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    private boolean checkCharacterNumber(String[] carNames) {
        for (String carName : carNames) {
            int nameLength = carName.length();

            if (nameLength > 5 || nameLength <= 0) {
                return false;
            }
        }
        return true;
    }


}
