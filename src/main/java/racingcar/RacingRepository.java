package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingRepository {
    List<Car> carList = new ArrayList<>();

    void addCar(Car car) {
        carList.add(car);
    }
}
