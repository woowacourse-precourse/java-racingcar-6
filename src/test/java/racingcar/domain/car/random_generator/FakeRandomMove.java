package racingcar.domain.car.random_generator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.RandomUtil;

public class FakeRandomMove implements RandomUtil {
    private int start;
    private int end;

    public FakeRandomMove(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean moveForward() {
        int number = Randoms.pickNumberInRange(start, end);
        return number >= 4;
    }
}
