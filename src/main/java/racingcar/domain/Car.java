package racingcar.domain;

public class Car implements Comparable{
    private final int MOVE_FORWARD_CONDITION = 4;
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
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
