package racingcar.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    private RacingCars(final String carNames, final RaceNumberGenerator raceNumberGenerator) {
        this.cars = stringToList(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarCount() {
        return cars.size();
    }


    public void race() {
        for (Car car : cars) {
            car.isCarMove();
        }
    }

    public List<Car> stringToList(final String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::create)
                .collect(Collectors.toList());
    }
}
