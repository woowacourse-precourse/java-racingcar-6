package racingcar.game;

public class Car {
    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
        this.distance = "";
    }

    public void moveForward() {
        distance += "-";
    }
}