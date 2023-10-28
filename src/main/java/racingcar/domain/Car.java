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
        if (generateRandomNumber() >= 4) {
            move.increaseMove();
        }
    }

    private int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
