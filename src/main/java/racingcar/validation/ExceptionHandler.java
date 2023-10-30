package racingcar.validation;

public final class ExceptionHandler {
    public static void throwIfStringLengthOverFive() {
        throw new IllegalArgumentException("자동차 이름의 길이는 5를 넘어가면 안됩니다.");
    }
}
