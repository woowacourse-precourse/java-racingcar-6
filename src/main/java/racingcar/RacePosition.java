package racingcar;

public class RacePosition {

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
}