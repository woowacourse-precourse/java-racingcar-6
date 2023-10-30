package racingcar.util;

public final class ExceptionHandler {
    public static void throwIfStringLengthOverFive() {
        throw new IllegalArgumentException("자동차 이름의 길이는 5를 넘어가면 안됩니다.");
    }

    public static void throwIfNumberIsZeroOrNegative() {
        throw new IllegalArgumentException("횟수는 0보다 커야합니다.");
    }
}
