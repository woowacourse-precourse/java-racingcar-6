package racingcar.model;

public class Game {
    private int randomNum;
    private static final int MOVEMENT_NUM = 4;
    public Game(int randomNum) {
        this.randomNum = randomNum;
    }

    public boolean move() {
        if (randomNum >= MOVEMENT_NUM) {
            return true;
        }
        return false;
    }
}
