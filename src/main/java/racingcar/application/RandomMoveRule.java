package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.policy.MoveRule;

public class RandomMoveRule implements MoveRule {
    @Override
    public int generateValue(int minRange, int maxRange) {
        return Randoms.pickNumberInRange(minRange, maxRange);
    }
}