package racingcar.model;

import racingcar.enums.Common;
import racingcar.enums.ErrorMessages;
import racingcar.utils.CommonValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        validateCarNamesInput(carNames);
        String[] carNameArray = carNames.split(Common.SEPARATOR.getStringValue());
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void everyCarMoveForwardByRandom() {
        for (Car car : cars) {
            car.moveForwardByRandom();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(String carName) {
        for (Car car : cars) {
            if (car.getName().equals(carName))
                return car;
        }

        throw new IllegalArgumentException(ErrorMessages.REGISTER_ERROR.getMessage());
    }

    private void validateCarNamesInput(String carNames) {
        String[] carNamesArray = carNames.split(Common.SEPARATOR.getStringValue());
        if (!CommonValidator.isPositive(carNamesArray.length))
            throw new IllegalArgumentException(ErrorMessages.SEPARATOR_ERROR.getMessage());
        if (CommonValidator.isDuplicate(carNamesArray))
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NAME_ERROR.getMessage());
    }
}
