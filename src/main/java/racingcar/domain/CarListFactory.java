package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarListFactory {

    public CarList create(String input) {
        List<Car> list = new ArrayList<>();

        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            list.add(car);
        }

        return new CarList(list);
    }
}
