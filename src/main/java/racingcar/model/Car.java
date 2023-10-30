package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int totalMove = 0;

    public int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveForward(int randNum) {
        if (randNum >= 4) {
            this.totalMove++;
        }
    }

    public void putName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalMove(){ return this.totalMove; }

}
