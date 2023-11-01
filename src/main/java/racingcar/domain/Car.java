package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String RESULT_DELIMITER = ", ";

    private final String name;
    private Integer moveDistance;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.moveDistance = 0;
    }

    public void forward(Judgment judgment, Integer number) {
        if (judgment.isMoreThanFour(number)) {
            moveDistance++;
        }
    }

    public String currentLocation() {
        return name + " : " + "-".repeat(Math.max(0, moveDistance));
    }

    public StringBuilder isEqualDistance(List<Car> carList) {
        List<String> names = carList.stream()
                .filter(car -> Objects.equals(this.moveDistance, car.moveDistance))
                .map(car -> car.name)
                .toList();
        return new StringBuilder(String.join(RESULT_DELIMITER, names));
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(otherCar.moveDistance, this.moveDistance);
    }
}
