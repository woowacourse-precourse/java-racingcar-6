package racingcar.utils.enums;

public enum Constraints {
    MIN_SIZE(1), //자동차 이름 최소 길이
    MAX_SIZE(5), //자동차 이름 최대 길이
    MIN_NUM(0), //랜덤 숫자 최소값
    MAX_NUM(9), //랜덤 숫자 최대값
    MINIMUM_FOR_FORWARD(4), //앞으로 움직일 수 있는 조건 숫자
    MINIMUM_POSITIVE_NUMBER(1); // 양수 조건 숫자

    private final int value;

    Constraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}