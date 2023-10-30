package racingcar;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {

    public void isNameValidated(String[] strings) {
        if (!isValidatedPlayerNum(strings)) {
            throw new IllegalArgumentException("플레이어수");
        }
        if (!isValidatedLength(strings)) {
            throw new IllegalArgumentException("길이");
        }
        if (!isValidatedDuplication(strings)) {
            throw new IllegalArgumentException("중복");
        }
    }

    public void isTimesValidated(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("정수 아님");
        }
    }

    public boolean isValidatedPlayerNum(String[] strings) {
        if (strings.length > 1) {
            return true;
        }
        return false;
    }

    public boolean isValidatedLength(String[] strings) {
        for (String string : strings) {
            if (string.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidatedDuplication(String[] strings) {
        HashSet<String> checkList = new HashSet<String>(Arrays.asList(strings));
        if (checkList.size() == strings.length) {
            return true;
        }
        return false;
    }
}
