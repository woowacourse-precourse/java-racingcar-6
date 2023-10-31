package racingcar.Domain;

import static racingcar.Domain.RaceNumberGenerator.generateRandomNumber;
import static racingcar.Service.CarService.stringToList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;
    private final RaceNumberGenerator generateRandomNumber;

    private RacingCars(final String carNames, final RaceNumberGenerator generateRandomNumber) {
        this.cars = stringToList(carNames);
        this.generateRandomNumber = generateRandomNumber;
    }

    public static RacingCars create(final String carNames, final RaceNumberGenerator generateRandomNumber) {
        if (carNames == null) {
            throw new IllegalArgumentException();
        }
        return new RacingCars(carNames, generateRandomNumber);
//        try {
//            return new RacingCars(carNames, generateRandomNumber);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }

    public void race() {
        for (Car car : cars) {
            int num = generateRandomNumber();
            car.CarMove(num);
        }
    }

    public List<Car> getCars() {
        return cars;
    }


}
