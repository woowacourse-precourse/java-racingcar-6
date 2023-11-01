package racingcar.domain;


public class Car {

    private static final int INCREASE_DISTANCE_COUNT = 1;
    private final Name name;
    private int distance = 0;

    private Car(String inputName) {
        this.name = Name.nameOf(inputName);
    }

    public static Car nameOf(String name) {
        return new Car(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance;
    }

    public void advance() {
        distance = distance + INCREASE_DISTANCE_COUNT;
    }
}
