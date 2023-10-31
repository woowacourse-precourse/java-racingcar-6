package racingcar.domain;


import static racingcar.util.MagicNumber.MAX_NAME_LENGTH;
import static racingcar.util.MagicNumber.MOVING_FORWARD;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance;

    private Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car makeCarByName(String name) {
        return new Car(name);
    }

    public static Car makeCarByNameDistance(String name, int distance) {
        return new Car(name, distance);
    }

    public void validateCarName(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH.getNumber()) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1~5 사이입니다.");
        }
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD.getNumber()) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isSameDistance(Car compareCar) {
        return this.distance == compareCar.distance;
    }

    @Override
    public int compareTo(Car compareCar) {
        return this.distance - compareCar.distance;
    }
}
