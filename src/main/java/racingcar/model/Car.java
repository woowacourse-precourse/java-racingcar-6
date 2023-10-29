package racingcar.model;

public class Car {

    private int distance = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

}
