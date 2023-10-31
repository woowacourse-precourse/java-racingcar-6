package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;

    public boolean isAvailableMove() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            return true;
        }
        return false;
    }

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
