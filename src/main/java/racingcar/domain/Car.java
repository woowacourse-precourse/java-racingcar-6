package racingcar.domain;

public class Car {

    String name;
    int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        distance++;
    }

}
