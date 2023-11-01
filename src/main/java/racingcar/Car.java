package racingcar;

public class Car {
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
        if (number >= Constants.MOVE_CONDITION_STANDARD) {
            addDistance();
        }
    }

    private void addDistance() {
        this.distance++;
    }
}
