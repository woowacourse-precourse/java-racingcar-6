package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
