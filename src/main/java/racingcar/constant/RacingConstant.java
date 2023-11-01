package racingcar.constant;

public enum RacingConstant {
    MAX_CAR_NAME_LENGTH(5), // 자동차 이름 최대 길이
    FORWARD_NUMBER(4);  // 전진 가능한 숫자의 최대 값

    private final int value;

    RacingConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

