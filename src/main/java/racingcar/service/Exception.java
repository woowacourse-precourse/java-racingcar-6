package racingcar.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String BLANK = " ";
    public static List<String> carNames;

    public static String checkCarName(String inputValue) throws IllegalArgumentException {
        checkEmpty(inputValue);

        carNames = Arrays.asList(inputValue.split(","));
        for (String name : carNames) {
            checkNoName(name);
            checkBlank(name);
            checkLength(name);
        }

        checkSameName();
        return inputValue;
    }

    public static String checkRaceCount(String inputValue) throws IllegalArgumentException {
        checkEmpty(inputValue);
        checkInteger(inputValue);
        checkZero(inputValue);
        return inputValue;
    }

    private static void checkEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException("잘못된 값 입력 : 입력 값을 넣어주세요.");
        }
    }

    private static void checkNoName(String inputValue) {
        if (inputValue.isEmpty() || inputValue.equals(BLANK)) {
            throw new IllegalArgumentException("잘못된 값 입력 : 입력되지 않은 자동차 이름이 있습니다.");
        }
    }

    private static void checkBlank(String inputValue) {
        if (inputValue.contains(BLANK)) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름에는 공백이 들어갈 수 없습니다.");
        }
    }

    private static void checkLength(String inputValue) {
        if (inputValue.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름은 5자 이내로 입력해주세요");
        }
    }

    private static void checkSameName() {
        Set<String> setTypeCarNames = new HashSet<>(carNames);
        if (carNames.size() != setTypeCarNames.size()) {
            throw new IllegalArgumentException("잘못된 값 입력 : 중복된 자동차 이름이 있습니다.");
        }
    }

    private static void checkInteger(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값 입력 : 숫자만 입력 가능합니다.");
        }
    }

    private static void checkZero(String inputValue) {
        if (inputValue.equals("0")) {
            throw new IllegalArgumentException("잘못된 값 입력 : 1 이상의 값을 입력해주세요.");
        }
    }
}