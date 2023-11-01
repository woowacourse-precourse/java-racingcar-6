package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.RacingCarConstants.RANDOM_MAX;
import static racingcar.constants.RacingCarConstants.RANDOM_MIN;

public class RandomNumberService {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN.getValue(), RANDOM_MAX.getValue());
    }

}