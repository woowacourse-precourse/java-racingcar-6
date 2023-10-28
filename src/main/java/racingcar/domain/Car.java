package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Name name;
    private Move move;

    public Car(Name name, Move move) {
        this.name = name;
        this.move = move;
    }

    public void moveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            move.increaseMove();
        }
    }
}
