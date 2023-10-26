package racingcar.domain;

public class Car {

    private int location = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        location++;
    }

    public void validateNameSize(String name) {

    }

    public int getLocation() {
        return location;
    }
}
