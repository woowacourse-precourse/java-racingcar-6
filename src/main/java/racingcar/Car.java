package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        if(name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }
}
