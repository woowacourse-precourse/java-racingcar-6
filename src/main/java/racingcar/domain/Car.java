package racingcar.domain;

public class Car {

    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        distance++;
    }

}
