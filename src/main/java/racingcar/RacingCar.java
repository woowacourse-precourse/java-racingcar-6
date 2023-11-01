package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    String name;
    int moveCount;
    StringBuilder moveBar = new StringBuilder();

    public RacingCar(String name) {
        this.name = name;
    }
    int rollDice() {
        int diceNumber = Randoms.pickNumberInRange(0,9);
        return diceNumber;
    }
    void move(int diceNumber) {
        if (4 <= diceNumber) {
            moveBar.append("-");
        }
    }
    int showMoveCount() {
        return moveCount;
    }
    String showMoveBar() {
        return moveBar.toString();
    }
}
