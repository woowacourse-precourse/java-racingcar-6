package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.GameRules;

public class NumberGenerator {
    private NumberGenerator() {
    }

    public static int generateNumber() {
        return Randoms.pickNumberInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue());
    }
}