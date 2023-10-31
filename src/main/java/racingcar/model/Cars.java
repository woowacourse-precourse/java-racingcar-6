package racingcar.model;

import racingcar.enums.Common;
import racingcar.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(String carNames) {
        Validator.validateCarNamesInput(carNames);
        String[] carNameArray = carNames.split(Common.SEPARATOR.getStringValue());
        for (String carName : carNameArray) {
            carList.add(new Car(carName));
        }
    }

    public void everyCarMoveForward() {
        for (Car car : carList) {
            car.moveForward();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
