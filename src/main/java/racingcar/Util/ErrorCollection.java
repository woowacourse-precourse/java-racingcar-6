package racingcar.Util;

public class ErrorCollection {

    public static void IllegalEmptyInput() {
        throw  new IllegalArgumentException("올바르지 않은 입력입니다.");
    }

    public static void IllegalCarNames() {
        throw new IllegalArgumentException("올바르지 않은 입력입니다. 자동차 이름은 5자 이하만 가능합니다.\n올바른 예) pobi,woni,jun\n");
    }

    public static void IllegalAttempts() {
        throw new IllegalArgumentException("올바르지 않은 입력입니다. 숫자만 입력해 주세요.");
    }
}
