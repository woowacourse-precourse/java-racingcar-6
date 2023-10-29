package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarRacingAdmin {
    private List<Car> getReadyCars(String carNames) {
        InputValidator.validateCarNames(carNames);
        String[] carNameArray = carNames.split(",");
        for (String carName : carNameArray) {
            InputValidator.validateCarName(carName);
        }

        List<Car> cars = Arrays.stream(carNameArray)
                .map(Car::new)
                .toList();

        return cars;
    }
}
