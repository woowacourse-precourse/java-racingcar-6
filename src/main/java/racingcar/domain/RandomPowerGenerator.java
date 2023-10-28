package racingcar.domain;

import static racingcar.message.MessageConstants.NINE;
import static racingcar.message.MessageConstants.ZERO;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPowerGenerator implements PowerGenerator {

    @Override
    public int generatorPower() {
        return Randoms.pickNumberInRange(ZERO, NINE);
    }
}
