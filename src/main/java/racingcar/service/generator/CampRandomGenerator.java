package racingcar.service.generator;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CampRandomGenerator implements RandomGenerator {
    @Override
    public int generate() {
        return pickNumberInRange(0, 9);
    }
}
