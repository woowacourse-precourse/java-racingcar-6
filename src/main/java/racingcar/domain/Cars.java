package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public void add(String name) {
        cars.add(new Car(name));
    }

    public int size() {
        return cars.size();
    }

    public void racing() {
        for (Car car : cars) {
            car.race(Randoms.pickNumberInRange(0, 9));
        }
    }
}
