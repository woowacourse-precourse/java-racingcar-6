package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarService {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
