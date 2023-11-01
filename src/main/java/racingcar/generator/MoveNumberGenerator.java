package racingcar.generator;

import racingcar.enums.Constants;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MoveNumberGenerator {
    public static Integer generateNumber() {
        return pickNumberInRange(Constants.MIN_NUMBER.getNumber(), Constants.MAX_NUMBER.getNumber());
    }
}
