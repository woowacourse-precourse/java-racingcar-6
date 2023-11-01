package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constant.*;

public class CarsFactory {

    public Cars create(String input) {
        String[] carNames = input.split(INPUT_DELIM);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            checkCarNameIsValid(carName);

            Car car = new Car(carName);
            cars.add(car);
        }

        checkCarsEmpty(cars);
        return new Cars(cars);
    }

    //==검증 로직==//

    private void checkCarNameIsValid(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException(ERROR_INPUT_NAME);
    }

    private void checkCarsEmpty(List<Car> cars) {
        if (cars.isEmpty())
            throw new IllegalArgumentException(ERROR_EMPTY_CAR_LIST);
    }
}
