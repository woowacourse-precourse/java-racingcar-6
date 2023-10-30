package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Computer {
    public static int createRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
