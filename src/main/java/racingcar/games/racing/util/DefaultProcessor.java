package racingcar.games.racing.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.games.racing.domain.Car;

public class DefaultProcessor implements RacingProcessor {

    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;
    private static final int COMPARE_NUMBER = 4;

    @Override
    public void moveProcess(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (canMove(randomValue)) {
                car.move();
            }
        }
    }

    private boolean canMove(int value) {
        return value >= COMPARE_NUMBER;
    }
}
