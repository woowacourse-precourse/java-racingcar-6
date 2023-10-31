package racingcar;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {

    public void isNameValidated(String[] strings) {
        if (!isValidatedPlayerNum(strings)) {
            throw new IllegalArgumentException("플레이어 수가 두 명 이상이어야 합니다.");
        }
        if (!isValidatedLength(strings)) {
            throw new IllegalArgumentException("5자를 넘어가는 자동차 이름이 존재합니다.");
        }
        if (!isValidatedDuplication(strings)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    public void isTimesValidated(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
        if (number < 0) {
            throw new IllegalArgumentException("음의 정수는 입력될 수 없습니다.");
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
