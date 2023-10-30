package racingcar.model;

public class Car {
    private String name;
    private int distance;

    private Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static Car makeCarByName(String carName) {
        return new Car(carName);
    }
}
