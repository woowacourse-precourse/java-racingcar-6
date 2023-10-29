package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> factory(List<String> stringNames) {
        List<Car> res = new ArrayList<>();
        for (String name : stringNames) {
            Car car = new Car(name);
            res.add(car);
        }
        return res;
    }
}
