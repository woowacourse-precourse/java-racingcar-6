package model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racingcar {
    private String name;
    private int position;

    public Racingcar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
            position++;
        }
    }
}
