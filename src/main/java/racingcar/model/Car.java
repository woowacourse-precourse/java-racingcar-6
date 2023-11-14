package racingcar.model;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_FORWARD_COUNT = 0;
    private final String name;
    private int forwardCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public Car(String name, int forwardCount) {
        this(name);
        validateForwardCount(forwardCount);
        this.forwardCount = forwardCount;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateForwardCount(int forwardCount) {
        if (forwardCount < MINIMUM_FORWARD_COUNT) {
            throw new IllegalArgumentException("전진 횟수는 0회 이상만 가능합니다.");
        }
    }

    public void moveForward() {
        forwardCount++;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
