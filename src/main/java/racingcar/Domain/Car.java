package racingcar.Domain;

public class Car {

    private String name;
    private int movingDistance;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.movingDistance++;
    }
}
