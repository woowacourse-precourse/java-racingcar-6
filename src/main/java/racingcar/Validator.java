package racingcar;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validator {
    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final String ERROR_MSG = "[ERROR] ";

    public static void isNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MSG + "입력 값이 공백입니다.");
        }
    }

    public static void nameLength(String input) {
        if (input.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(ERROR_MSG + "자동차 이름은 최대 5글자입니다.");
        }
    }

    public static void isSameName(String[] names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            nameList.add(name.trim());
        }
        for (String name : nameList) {
            if (Collections.frequency(nameList, name) != 1) {
                throw new IllegalArgumentException(ERROR_MSG + "중복된 이름을 입력했습니다.");
            }
        }
    }

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG + "시도 횟수는 숫자여야 합니다.");
        }
    }

    public static boolean checkNames(String[] names) {
        try {
            isSameName(names);
            for (String name : names) {
                isNull(name.trim());
                nameLength(name.trim());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean checkRound(String input) {
        try {
            isNull(input.trim());
            isNumeric(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}