package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int move;
    private int randomNumber;

    public RacingCar(String name) {
        this.name = name;
        this.move = 0;
    }

    public String getCarName() {
        return this.name;
    }


    public void moveRandomForward() {
        makeRandomNumber();
        if (isOverFour(randomNumber)) {
            moveForward();
        }
    }

    public void moveForward() {
        move++;
    }

    private void makeRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(Rule.minNumber, Rule.maxNumber);
    }

    private boolean isOverFour(int value) {
        return value >= Rule.standardValue;
    }

    public int getMove() {
        return this.move;
    }
}
