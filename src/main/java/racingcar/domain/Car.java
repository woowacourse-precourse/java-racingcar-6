package racingcar.domain;

public class Car {

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

    public static Car makeCar(String name) {
        return new Car(name);
    }

    public static Car makeCarByNameDistance(String name, int distance) {
        return new Car(name, distance);
    }

    public void validateCarName(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1~5 사이입니다.");
        }
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
