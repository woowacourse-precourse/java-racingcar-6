package racingcar.domain;

public class Car {
    private String name;
    private String location;

    public Car(String name) {
        this.name = name;
        location = "";
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
