package racingcar.domain;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void go() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
