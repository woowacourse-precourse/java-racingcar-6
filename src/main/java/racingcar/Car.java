package racingcar;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            addDistance();
        }
    }

    private void addDistance() {
        this.distance++;
    }
}
