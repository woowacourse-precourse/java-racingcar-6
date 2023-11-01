package racingcar.domain;

public class Car {

    private static final int MOVE_FORWARD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int winnersPosition) {
        return this.position == winnersPosition;
    }
}
