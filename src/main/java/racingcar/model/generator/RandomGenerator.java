package racingcar.model.generator;

import static racingcar.util.GameConstants.MAXIMUM_GENERATED_NUM;
import static racingcar.util.GameConstants.MINIMUM_GENERATED_NUM;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator implements MovementGenerator{
    @Override
    public int generateMovement() {
        return Randoms.pickNumberInRange(MINIMUM_GENERATED_NUM, MAXIMUM_GENERATED_NUM);
    }
}
