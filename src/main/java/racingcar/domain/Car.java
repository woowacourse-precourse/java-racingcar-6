package racingcar.domain;


public class Car {
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goForward() {
        this.location++;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
