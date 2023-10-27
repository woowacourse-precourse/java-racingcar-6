package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.GameRules;

public class NumberGenerator {
    private NumberGenerator() {
    }

    public static int generateNumber() {
        int randomNumber = Randoms.pickNumberInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue());
        return randomNumber;
    }
}
