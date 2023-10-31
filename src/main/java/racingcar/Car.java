package racingcar;

public class Car {

    private int distance;
    private final String name;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int DISTANCE_MIN = 0;


    public Car(String name, int distance) {
        constructorValidation(name, distance);
        this.name = name;
        this.distance = distance;
    }

    private void constructorValidation(String name, int distance) {
        if (name.isEmpty() || name.length() > NAME_MAX_LENGTH || distance < DISTANCE_MIN) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.distance);
    }
}
