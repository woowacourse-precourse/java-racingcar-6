package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
