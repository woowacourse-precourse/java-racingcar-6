package racingcar.domain;

public class Car {
    private final String name;
    private int move = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return move;
    }

    public String getMoveDistance() {
        return "-".repeat(move);
    }

    public void tryMove(int randomValue) {
        if (randomValue >= 4) {
            move++;
        }
    }
}
