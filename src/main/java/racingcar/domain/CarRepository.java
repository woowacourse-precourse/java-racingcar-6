package racingcar.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private static final List<Car> carList = new ArrayList<>();

    public void create(String[] cars) {
        for (String carName : cars) {
            carList.add(new Car(0, carName));
        }
    }

    public int size() {
        return carList.size();
    }

    public List<Car> find() {
        return unmodifiableList(carList);
    }

    public int findMaxAdvanceNum() {
        int max = 0;
        for (Car car : carList) {
            max = Math.max(max, car.findAdvanceNum());
        }
        return max;
    }
}