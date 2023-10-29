package racingcar.utils;

import static racingcar.model.constants.Rule.RANDOM_MAX_SIZE;
import static racingcar.model.constants.Rule.RANDOM_MIN_SIZE;

import camp.nextstep.edu.missionutils.Randoms;

public class GeneratorImp implements Generator {
    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_SIZE.getValue(), RANDOM_MAX_SIZE.getValue());
    }
}
