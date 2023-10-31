package racingcar.game;

public class Car {

    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.distance += "-";
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return this.distance;
    }
}
