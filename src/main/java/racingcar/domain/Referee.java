package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Referee {

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
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
