package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {


    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
