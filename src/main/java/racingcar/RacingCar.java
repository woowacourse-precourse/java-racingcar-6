package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void race() {
        if (canMoveForward()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
