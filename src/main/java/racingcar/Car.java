package racingcar;

public class Car {
    private static final String LOCATION = "-";
    private String name;
    private String location = "";

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        location += LOCATION;
    }

    @Override
    public String toString() {
        return name + " : " + location;
    }
}
