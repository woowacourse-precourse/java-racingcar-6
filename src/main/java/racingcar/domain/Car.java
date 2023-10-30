package racingcar.domain;

public class Car {
    private String name;
    private int location = 0;

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
