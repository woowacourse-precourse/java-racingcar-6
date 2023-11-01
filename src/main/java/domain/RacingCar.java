package domain;

public class RacingCar {
    private final String name;
    private int moveCount;

    public RacingCar(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
