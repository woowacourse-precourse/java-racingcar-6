package racingcar.domain;

import java.util.List;
import racingcar.vo.CarName;
import racingcar.vo.Cars;

public class Racing {
    private final Cars cars;

    public Racing(List<CarName> carNameList) {
        List<Car> carList = getCarList(carNameList);
        this.cars = new Cars(carList);
    }

    private static List<Car> getCarList(List<CarName> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .toList();
    }

}