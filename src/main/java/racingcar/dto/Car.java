package racingcar.dto;

public class Car {
    private final String name;
    private String state = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public void moveForward() {
        this.state += "-";
    }
}
