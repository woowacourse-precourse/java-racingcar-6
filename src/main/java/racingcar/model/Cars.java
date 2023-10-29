package racingcar.model;

import java.util.List;
import racingcar.exception.CarNamesValidator;
import racingcar.vo.CarName;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<CarName> carNames) {
        CarNamesValidator.validateCarNames(carNames);

        List<Car> carList =
                carNames.stream()
                        .map(Car::new)
                        .toList();

        this.carList = carList;
    }

    public void updateDistance() {
        carList.stream().forEach(car -> car.updateDistance());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
