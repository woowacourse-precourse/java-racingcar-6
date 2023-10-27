package racingcar;

public class RacePosition {

    private static final String PROCESS_HYPHEN = "-";

    private int currentPosition;

    public RacePosition() {
        this.currentPosition = 0;
    }

    public void moveForward() {
        this.currentPosition++;
    }

    public int compareTo(RacePosition other) {
        return Integer.compare(this.currentPosition, other.currentPosition);
    }

    @Override
    public String toString() {
        return String.valueOf(currentPosition);
    }

    public String drawProcess() {
        return PROCESS_HYPHEN.repeat(currentPosition);
    }
}