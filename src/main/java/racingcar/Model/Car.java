package racingcar.Model;

import racingcar.Utils.GameConstants;

public class Car {
    private String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int randomNum) {
        if (checkMovable(randomNum)) {
            moveCount++;
        }
    }

    private Boolean checkMovable(int randomNum) {
        return randomNum >= GameConstants.MOVE_NUMBER;
    }
}
