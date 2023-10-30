package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingNumber {

    private Integer number;

    public void generateAndSaveRandomNumber() {
        this.number = Randoms.pickNumberInRange(0, 9);
    }

    public boolean decideMoveOrStop(RacingNumber racingNumber) {
        return racingNumber.number >= 4;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
