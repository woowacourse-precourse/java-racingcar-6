package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private Integer randomNumber;

    public Integer getRandomNumber() {
        drawRandomNumber();
        return randomNumber;
    }

    private void drawRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
