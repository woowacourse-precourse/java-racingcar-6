package racingcar.service;

import static racingcar.model.OutputConstants.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceCountInput;
import racingcar.model.RacingGame;

public class CarService {
    private static Cars createCars(String userInput) {
        List<Car> carList = toCarList(userInput);
        return Cars.createCars(carList);
    }

    private static List<Car> toCarList(String userInput) {
        String value = DELIMITER.getValue();
        String[] splitList = userInput.split(value);
        return Arrays.stream(splitList)
                .map(String::trim)
                .map(Car::createCar)
                .collect(Collectors.toList());
    }

    public static RacingGame createRace(String userCars, String userCount) {
        Cars cars = createCars(userCars);
        RaceCountInput raceCountInput = RaceCountInput.createRaceCountInput(userCount);
        return new RacingGame(cars, raceCountInput);
    }
}
