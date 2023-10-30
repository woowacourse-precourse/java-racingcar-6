package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceCountInput;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;

public class CarService {
    private Cars createCars(String userInput) {
        List<Car> carList = toCarList(userInput);
        return Cars.createCars(carList);
    }

    private List<Car> toCarList(String userInput) {
        String[] splitList = userInput.split(",");
        return Arrays.stream(splitList)
                .map(String::trim)
                .map(Car::createCar)
                .collect(Collectors.toList());
    }

    public RacingGame createRace(String userCars, String userCount) {
        Cars cars = createCars(userCars);
        RandomNumberGenerator randomNumber = RandomNumberGenerator.createNumberGenerator();
        RaceCountInput raceCountInput = RaceCountInput.createRaceCountInput(userCount);
        return new RacingGame(cars, randomNumber, raceCountInput);
    }

}
