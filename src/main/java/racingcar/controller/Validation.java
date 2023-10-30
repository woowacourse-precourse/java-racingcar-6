package racingcar.controller;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final Pattern LOWERCASE_AND_COMMA = Pattern.compile("^[a-z,]*[a-z]$");
    private static final Pattern NUMBER = Pattern.compile("[0-9]*$");

    /**
     * 입력된 자동차 이름 데이터 유효성 검사
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
        if (!checkDuplicate(carNames)) {
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

    private boolean checkDuplicate(String[] carNames) {
        Arrays.sort(carNames);

        for (int i = 0; i < carNames.length - 1; i++) {
            if (carNames[i].equals(carNames[i + 1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 입력받은 시도할 횟수 검증
     * @param inputNumber
     * @return true || false
     */
    public boolean validationNumber(String inputNumber) {

        if (!checkNumberCharacter(inputNumber)) {
            return false;
        }
        if (!checkZero(inputNumber)) {
            return false;
        }
        return true;
    }

    private boolean checkNumberCharacter(String inputNumber) {
        Matcher matcher = NUMBER.matcher(inputNumber);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
    private boolean checkZero(String inputNumber) {
        if ("0".equals(inputNumber)) {
            return false;
        }
        return true;
    }
}
