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

    public void getName() {
        System.out.println(this.name);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

}