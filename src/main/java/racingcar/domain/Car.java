package racingcar.domain;

public class Car implements Comparable<Car> {
    private final int MOVE_FORWARD_CONDITION = 4;
    private final String DISTANCE_EXPRESS = "-";
    private final String DELIMITER = " : ";

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

    public void showMoveDistance() {
        StringBuilder movedDistance = new StringBuilder(name + DELIMITER);

        for (int i = 0; i < position; i++) {
            movedDistance.append(DISTANCE_EXPRESS);
        }

        System.out.println(movedDistance);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }
}
