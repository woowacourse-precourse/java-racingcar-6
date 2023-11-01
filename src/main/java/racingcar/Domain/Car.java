package racingcar.Domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int START_POSITION = 0;
    private static final int TICK = 1;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void moveForward() {
        if (RandomNumber.chooseRandomNumber() >= MOVE_THRESHOLD) {
            this.position += TICK;
        }
    }

    public int findFasterPosition(int fastestPosition) {
        return Math.max(this.position, fastestPosition);
    }

    public boolean isWinnerPosition(int winnerPosition) {
        return this.position == winnerPosition;
    }

    public String makePositionString (String positionStamp) {
        return this.name + " : "
                + positionStamp.repeat(this.position);
    }

    public String getName() {
        return this.name;
    }
}
