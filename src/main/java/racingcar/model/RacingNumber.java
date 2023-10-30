package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingNumber {

    private Integer number;

    public void generateAndSaveRandomNumber() {
        this.number = Randoms.pickNumberInRange(0, 9);
    }
}
