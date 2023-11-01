package racingcar.domain;

public class Car {

    private static final int MOVE_THRESHOLD= 4;
    private static final String MOVEMENT = "-";
    private static final String NEW_LINE = "\n";

    private int position = 0;
    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public int comparePosition(int position) {
        return Math.max(this.position, position);
    }

    public boolean isFurthestDistance(int furtherDistance) {
        return this.position == furtherDistance;
    }

    public Winner recognizeAsWinner() {
        return carName.registerAsWinner();
    }


    @Override
    public String toString() {
        return carName.makeNameForPrintResult() + MOVEMENT.repeat(position) + NEW_LINE;
    }
}
