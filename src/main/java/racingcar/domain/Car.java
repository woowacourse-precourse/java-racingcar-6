package racingcar.domain;

public class Car {
    private static final int MIN_MOVE_POINT_TO_MOVE = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int distance = 0;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void go(int movePoint) {
        if (isMove(movePoint)) {
            distance++;
        }
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (name.isBlank()) throw new IllegalArgumentException();
    }

    private boolean isMove(int movePoint) {
        return movePoint >= MIN_MOVE_POINT_TO_MOVE;
    }
}
