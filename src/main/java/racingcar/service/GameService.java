package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int STANDARD_NUMBER = 4;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public boolean isBiggerThanStandard(int number) {
        return number >= STANDARD_NUMBER;
    }
}
