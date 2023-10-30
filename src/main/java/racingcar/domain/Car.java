package racingcar.domain;

public class Car {
    private String name;
    private String location;

    public Car() {
        name = "";
        location = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
