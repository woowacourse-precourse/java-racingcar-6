package racingcar.models;

public class Car {
    private final String name;
    private int moveDistance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void proceed() {
        moveDistance++;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public boolean isWinner(int winnerDistance) {
        return moveDistance == winnerDistance;
    }
}
