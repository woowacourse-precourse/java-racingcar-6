package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    List<Car> cars = new ArrayList<>();

    public void drive(Car car) {
        car.go(createMovePoint());
    }

    private int createMovePoint() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
