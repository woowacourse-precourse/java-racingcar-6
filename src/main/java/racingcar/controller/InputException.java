package racingcar.controller;

public class InputException {
    private InputException() {}
    public static void checkNameLength(String newCarName) { // 이름 길이 5자 초과 예외처리
        if (newCarName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
