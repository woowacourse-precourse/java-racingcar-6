package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constant.*;

public class CarListFactory {

    public CarList create(String input) {
        String[] carNames = input.split(INPUT_DELIM);

        List<Car> list = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            list.add(car);
        }

        return new CarList(list);
    }
}
