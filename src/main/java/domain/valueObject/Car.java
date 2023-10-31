package domain.valueObject;

import domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private static final int MAXIMUM_LENGTH = 5;
    private static final int MINIMUM_LENGTH = 1;
    private static final String ERROR_MESSAGE_NULL_NAME = "이름을 올바르게 입력해 주세요";
    private static final String ERROR_MESSAGE_NOT_ALLOWED_SIZE = "이름의 길이는 %d - %d 사이여야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        isNotNull(name);
        String trimName = trimName(name);
        checkNameLength(trimName);

        this.name = trimName;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private static void isNotNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL_NAME);
        }
    }

    private static String trimName(String name) {
        return name.trim();
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAXIMUM_LENGTH || name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE_NOT_ALLOWED_SIZE, MINIMUM_LENGTH, MAXIMUM_LENGTH));
        }
    }

    public boolean isEqualPosition(final Car car) {
        return this.position == car.position;
    }

    public void forward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            this.position++;
        }
    }

    public int isWinning(final Car competition) {
        if (this.position > competition.position) {
            return -1;
        } else if (this.position < competition.position) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", position=" + position + '}';
    }

}
