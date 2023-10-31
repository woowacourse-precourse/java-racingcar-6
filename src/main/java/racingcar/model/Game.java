package racingcar.model;

public class Game {
    private final int randomNumber;
    private static final int MINIMUM_MOVEMENT_THRESHOLD = 4;

    public Game(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public boolean shouldMove() {
        return randomNumber >= MINIMUM_MOVEMENT_THRESHOLD;
    }
}