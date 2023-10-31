package racingcar.domain;

public class Car {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_VALUE_FOR_MOVING_FORWARD = 4; // 자동차가 전진하기 위한 최솟값

    private final String name;
    private int forwardCount; // 전진 횟수

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void validateNameLength(String name) {
        if (invalidNameLength(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 %d자 이상 %d자 이하만 가능합니다."
                    .formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    private boolean invalidNameLength(String name) {
        return !(MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH);
    }

    public int move(int valueForMovingForward) {
        if (valueForMovingForward >= MIN_VALUE_FOR_MOVING_FORWARD) {
            forwardCount++;
        }
        return forwardCount;
    }

    public boolean isForwardCountSameAs(int forwardCount) {
        return this.forwardCount == forwardCount;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
