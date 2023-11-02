package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validator {
    private static final int MAX_LENGTH_NAME = 5;
    private static final String EMPTY_MSG = "입력 값이 공백입니다.";
    private static final String DUPLICATION_MSG = "입력 값에 중복이 있습니다";
    private static final String OVER_LENGTH_MSG = "자동차 이름은 최대 5글자입니다.";
    private static final String IS_NOT_NUMBER_MSG = "숫자가 아닌 값이 들어왔습니다.";

    public static void isNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
    }

    public static void nameLength(String input) {
        if (input.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException(OVER_LENGTH_MSG);
        }
    }

    public static void isSameName(String[] names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            nameList.add(name.trim());
        }
        for (String name : nameList) {
            if (Collections.frequency(nameList, name) != 1) {
                throw new IllegalArgumentException(DUPLICATION_MSG);
            }
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER_MSG);
        }
    }

    public static boolean checkName(String[] names) {
        try {
            isSameName(names);
            for (String name : names) {
                isNull(name.trim());
                nameLength(name.trim());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 값이 오류입니다.");
        }
        return true;
    }

    public static boolean checkNumber(String input) {
        try {
            isNull(input.trim());
            isNumber(input.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 값이 오류입니다.");
        }
        return true;
    }


}
