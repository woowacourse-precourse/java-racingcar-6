package racingcar.Service;

import static racingcar.Domain.RaceNumberGenerator.generateRandomNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Domain.Car;
import racingcar.Domain.RacingCars;

public class CarService {
    private final RacingCars racingCars;

    public CarService(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static List<Car> stringToList(final String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::create)
                .collect(Collectors.toList());
    }

}
