package racingcar.domain;

import racingcar.domain.dto.output.CarsDto;
import racingcar.validator.CarNameValidator;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNameList) {
        CarNameValidator.validateDuplicatedName(carNameList);
        CarNameValidator.validateNameLength(carNameList);
        this.carList = carNameList.stream()
                .map(Car::new)
                .toList();
    }

    public static Cars from(List<String> carNameList) {
        return new Cars(carNameList);
    }

    public void moveCarsBy(MovePossibilityChecker movePossibilityChecker) {
        for (Car car : carList) {
            car.moveBy(movePossibilityChecker);
        }
    }

    public CarsDto toCarsDto() {
        return new CarsDto(carList.stream().map(Car::toCarDto).toList());
    }
}
