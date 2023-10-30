package racingcar.model;

public class Game {
    private final int randomNum;
    private static final int MOVEMENT_NUM = 4;
    public Game(int randomNum) {
        this.randomNum = randomNum;
    }

    public boolean move() {
        return randomNum >= MOVEMENT_NUM;
    }
}
