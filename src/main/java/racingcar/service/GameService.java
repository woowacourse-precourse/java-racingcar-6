package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
