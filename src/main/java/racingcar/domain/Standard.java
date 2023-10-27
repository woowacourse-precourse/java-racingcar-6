package racingcar.domain;

/**
 * 무작위 숫자가 4가 넘는지 비교하기 위한 enum
 */
public enum Standard {
    goeFour(4);

    private final int value;

    Standard(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
