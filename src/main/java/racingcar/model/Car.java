package racingcar.model;

public class Car {
    String name;
    int distance = 0;

    public Car(String name) {
        this.name = name;
        move();
    }

    public void move() {
        distance++;
    }
}
