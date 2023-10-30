package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarList;

public class RacingGame {

    private CarList carList;

    public CarList generateCar(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        return carList = new CarList(cars);
    }
}
