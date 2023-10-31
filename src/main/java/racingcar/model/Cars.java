package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Validator;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    public Cars(String[] carNames) {
        for(String carName : carNames) {
            Validator.validateName(carName);
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
