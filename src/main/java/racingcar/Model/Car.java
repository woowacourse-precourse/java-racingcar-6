package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moves = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryMove() {
        if (canMove()) {
            moves++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMoves() {
        return this.moves;
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

}