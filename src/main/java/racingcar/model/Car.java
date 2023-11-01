package racingcar.model;

public class Car {

    private int distance;

    public Car(String name) {
        this.distance = 0;
    }

    public void advance() {
        this.distance += 1;
    }

    public int getDistance() {
        return this.distance;
    }

}
