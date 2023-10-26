package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

public class CarMover {
    static boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
