package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarRacingAdmin {
    public void startRace() {
        String carNames = RacingCarConsole.readCarNames();
        List<Car> cars = getReadyCars(carNames);

        int iterationNumBer = RacingCarConsole.readIterationNumBer();
        InputValidator.validateIterationNumBer(iterationNumBer);

        CarRacing carRacing = new CarRacing(cars, iterationNumBer);
        List<CarRacingResult> championCars = carRacing.start();
        RacingCarConsole.printChampionCars(championCars);
    }

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
