package racingcar.domain;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private String name;
    private int movedCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.movedCount = 0;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("rejected value: %s\n자동차 이름은 1자 이상 %d자 이하만 가능합니다.", name, CAR_NAME_MAX_LENGTH)
            );
        }
    }

    public void move() {
        movedCount++;
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }
}
