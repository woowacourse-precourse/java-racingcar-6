package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moves;

    public Car(String name) {
        this.name = name;
        this.moves = 0;
    }

    public void moveForward() {
        int num = getRandomNumber();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
