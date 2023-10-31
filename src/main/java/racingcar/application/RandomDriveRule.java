package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.policy.DriveRule;

public class RandomDriveRule implements DriveRule {
    @Override
    public int generateValue(int minRange, int maxRange) {
        return Randoms.pickNumberInRange(minRange, maxRange);
    }
}