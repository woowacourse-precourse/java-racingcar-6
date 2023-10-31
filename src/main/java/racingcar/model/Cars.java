package racingcar.model;

import java.util.List;
import racingcar.util.validation.CarNamesValidator;
import racingcar.vo.CarName;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<CarName> carNames) {
        CarNamesValidator.validateCarNames(carNames);

        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        this.carList = carList;
    }

    public void updatePosition() {
        carList.stream().forEach(car -> car.updatePosition());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
