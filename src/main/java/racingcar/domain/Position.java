package racingcar.domain;

public class Position {

    private final static int MOVING_FORWARD_CRITERION = 4;
    private final static int INIT_POSITION_CRITERION = 0;

    private int position;

    public Position() {
        this.position = INIT_POSITION_CRITERION;
    }

    public void move() {
        this.position++;
    }

    public boolean isMovable(int number) {
        return number >= MOVING_FORWARD_CRITERION;
    }

    public int getPosition() {
        return position;
    }
}
