package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.domain.MoveStatus.*;

public class RandomMovementGenerator {

    public static MoveStatus generate() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            return GO;
        }
        return STOP;
    }
}
