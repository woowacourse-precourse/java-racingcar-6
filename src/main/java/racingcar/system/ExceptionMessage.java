package racingcar.system;

public enum ExceptionMessage {
    OUT_OF_RANGE("5자를 초과한 자동차 이름이 있습니다.\n"),
    IS_NULL("이름이 비어있는 자동차가 있습니다.\n"),
    IS_TOTALLY_NULL("아무런 입력도 주어지지 않았습니다."),
    DISTINCT("동명이인은 허용되지 않습니다.\n"),
    TRY_NUMERAL("정수형태를 벗어난 입력이 주어졌습니다.\n"),
    TRY_POSITIVE("양수가 아닌 입력이 주어졌습니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
