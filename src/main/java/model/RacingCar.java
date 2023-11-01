package model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
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
