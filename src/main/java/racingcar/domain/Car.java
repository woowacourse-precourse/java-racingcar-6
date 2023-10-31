package racingcar.domain;

public class Car {

    private final int MOVE_BOUND = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void move() {
        position++;
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= MOVE_BOUND) {
            move();
        }
    }
}
