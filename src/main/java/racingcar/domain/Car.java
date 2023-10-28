package racingcar.domain;

public class Car {
    private final String name;
    private Integer location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(){
        location += 1;
    }

    public String getLocationResult() {
        return "-".repeat(location);
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }
}
