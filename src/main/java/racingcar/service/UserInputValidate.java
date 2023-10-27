package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class UserInputValidate {
    public List<Car> validate(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            Car car = Car.createCar(name, new StringBuilder());
            cars.add(car);
        }

        return cars;
    }
}
