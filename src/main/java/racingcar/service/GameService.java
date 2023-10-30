package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    private final int STANDARD_NUMBER = 4;

    public boolean isBiggerThanStandard(int number) {
        return number >= STANDARD_NUMBER;
    }

}
