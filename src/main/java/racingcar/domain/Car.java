package racingcar.domain;

public class Car implements Comparable<Car> {
    private final int MOVE_FORWARD_CONDITION = 4;
    private final String DISTANCE_EXPRESS = "-";
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_CONDITION) {
            position++;
        }
    }

    public String expressMoveDistance() {
        String movedDistance = "";

        for (int i = 0; i < position; i++) {
            movedDistance += DISTANCE_EXPRESS;
        }

        return name + " : " + movedDistance;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }
}
