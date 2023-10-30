package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constant.*;

public class CarsFactory {

    public Cars create(String input) {
        String[] carNames = input.split(INPUT_DELIM);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return new Cars(cars);
    }
}
