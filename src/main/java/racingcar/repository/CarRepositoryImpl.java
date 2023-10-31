package racingcar.repository;

import racingcar.domain.Car;
import racingcar.validate.InputValueValidate;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.NumberConstant.MOVE_FORWARD_VALUE;

public class CarRepositoryImpl implements Repository<Car> {

    @Override
    public List<Car> save(String[] inputNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : inputNames) {
            InputValueValidate.checkNameException(name);
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    @Override
    public void moveForward(Car car, int value) {
        if (value >= MOVE_FORWARD_VALUE.getNumber()) {
            car.moveForward();
        }
    }
}
