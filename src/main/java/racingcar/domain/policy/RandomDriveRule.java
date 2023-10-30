package racingcar.domain.policy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDriveRule implements DriveRule{
    @Override
    public int generateValue(int minRange, int maxRange) {
        return Randoms.pickNumberInRange(0 ,9);
    }
}
