package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class GameService {

    private final Validator validator;

    public GameService() {
        this.validator = new Validator();
    }

    public List<Car> validateInput(List<Car> carList) {
        validator.validate(carList);
        return carList;
    }

    public List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}
