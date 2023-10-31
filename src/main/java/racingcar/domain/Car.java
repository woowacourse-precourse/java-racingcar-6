package racingcar.domain;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.exception.ExceptionMsg.INVALID_BLANK;
import static racingcar.exception.ExceptionMsg.INVALID_LENGTH_NAME;

public class Car {

    private static final int VALID_MAX_LENGTH = 5;
    private static final String MOVE = "-";
    private static final String DELIMITER = " : ";
    private final String name;
    private int move;


    private Car(final String name) {
        this.name = name;
        this.move = 0;
    }

    public static Car createCar(String name) {
        name = name.trim();

        validateBlank(name);
        validateNameLength(name);

        return new Car(name);
    }

    public void moveForward() {
        this.move++;
    }

    public int getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public String getCarStatus() {
        String name = this.name + DELIMITER;

        String move = IntStream.range(0, this.move)
                .mapToObj(i -> MOVE)
                .collect(Collectors.joining());

        return name + move;
    }

    private static void validateNameLength(String name) {
        if (name.length() > VALID_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_NAME.getMessage());
        }
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_BLANK.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
