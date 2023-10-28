package racingcar.Model;

import java.util.List;

import racingcar.Validator;

public class Cars {

    private List<Car> cars;
    private Validator validator = new Validator();

    public Cars(List<Car> cars) {
        validator.validateCarsNames(cars);
        this.cars = cars;
    }
}
