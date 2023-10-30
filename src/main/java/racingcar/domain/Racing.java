package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    public Racing(List<Car> cars) {
        this.participant = cars;
    }

    List<Car> participant = new ArrayList<>();

    public void drive(Car car) {
        car.go(createMovePoint());
    }

    private int createMovePoint() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
