package racingcar.Model;

public class Car {
    private static final int START_LOCATION = 0;
    private final String name;
    private int location;

    private Car(String name) {
        this.name = name;
        this.location = START_LOCATION;
    }

    public static Car from(String name) {
        return new Car(name);
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