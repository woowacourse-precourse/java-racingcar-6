package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
