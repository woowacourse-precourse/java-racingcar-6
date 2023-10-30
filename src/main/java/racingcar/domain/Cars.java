package racingcar.domain;

import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        CarNameValidator.validateDuplicatedName(carNameList);
        CarNameValidator.validateNameLength(carNameList);
        for (String name : carNameList) {
            cars.add(new Car(name));
        }
        this.carList = cars;
    }

    public static Cars from(List<String> carNameList) {
        return new Cars(carNameList);
    }
}
