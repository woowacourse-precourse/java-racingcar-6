package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private final String name;
    private int position;

    public Car(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %d~%d 사이여야 합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH)
            );
        }
    }
}
