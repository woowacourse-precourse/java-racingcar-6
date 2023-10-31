package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private int randomNum;

    RandomNumber() {
    }

    public void make() {
        this.randomNum = pickNumberInRange(0, 9);
    }

    public boolean isForward() {
        if (this.randomNum >= 4) {
            return true;
        }
        return false;
    }
}
