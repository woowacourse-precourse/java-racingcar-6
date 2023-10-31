package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Referee {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int OVER_CONDITION = 4;

    public List<Car> selectWinnerList(List<Car> list) {
        list.sort((o1, o2) -> Integer.compare(o2.getDistance(), o1.getDistance()));
        return list;
    }

    public void startEngine(Car car) {
        if (canStart()) {
            car.accel();
        }
    }

    private boolean canStart() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= OVER_CONDITION;
    }
}
