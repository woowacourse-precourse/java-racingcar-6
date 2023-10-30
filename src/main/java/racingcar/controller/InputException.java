package racingcar.controller;

import static racingcar.utility.Constants.ONLYINT;

public class InputException {
    private InputException() {}
    public static void checkNameLength(String newCarName) { // 이름 길이 5자 초과 예외처리
        if (newCarName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkOnlyInt(String newCarName) { // 숫자로만 이루어진 이름 예외처리
        if (newCarName.matches(ONLYINT)) {
            throw new IllegalArgumentException();
        }
    }
}
