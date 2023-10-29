package racingcar.domain;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void saveCarName(String input) {
        this.name = input;
    }

    public void increaseDistance() {
        distance++;
    }
}
