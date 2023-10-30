package racingcar.domain;

public class Car {
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 5글자 이하만 가능합니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;


    private Car(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static Car getNewCar(String name) {
        return new Car(name);
    }

    public void move(boolean isCanMove) {
        if (isCanMove) {
            position += 1;
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }
}
