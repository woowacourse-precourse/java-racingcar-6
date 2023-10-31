package racingcar.model;

import java.util.ArrayList;
import racingcar.utils.Validator;

public class Cars {

    private final ArrayList<Car> cars = new ArrayList<>();
    public Cars(String[] carNames) {
        for(String carName : carNames) {
            Validator.validateName(carName);
            Car car = new Car(carName);
            cars.add(car);
        }
    }
}
