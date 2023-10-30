package racingcar.validator.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.NullException;
import racingcar.exception.cars.DuplicateException;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;

public class CarsValidator extends ModelValidator {
    @Override
    public void validate(Object target) {
        Cars cars = (Cars) target;
        validateCarList(cars.getCarList());
    }

    private void validateCarList(List<Car> carList) {
        validateNull(carList);
        validateDuplicateName(carList);
    }

    private void validateNull(List<Car> carList) {
        if (carList == null) {
            throw new NullException();
        }
    }

    private void validateDuplicateName(List<Car> carList) {
        List<CarName> carNameList = new ArrayList<>();
        for (Car car : carList) {
            carNameList.add(car.getCarName());
        }

        if (carNameList.stream()
                .distinct()
                .count() != carNameList.size()) {
            throw new DuplicateException();
        }
    }
}
