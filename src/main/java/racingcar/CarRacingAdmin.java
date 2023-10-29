package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.console.RacingCarConsole;
import racingcar.validator.InputValidator;

public class CarRacingAdmin {
    public void startRace() {
        String carNames = RacingCarConsole.readCarNames();
        List<Car> cars = getReadyCars(carNames);

        int iterationNumBer = RacingCarConsole.readIterationNumBer();
        InputValidator.validateIterationNumBer(iterationNumBer);

        CarRacing carRacing = new CarRacing(cars, iterationNumBer);
        CarRacingResult carRacingResult = carRacing.start();
        RacingCarConsole.printCarRacingResult(carRacingResult);
    }

    private List<Car> getReadyCars(String carNames) {
        InputValidator.validateCarNames(carNames);
        String[] carNameArray = carNames.split(",");
        for (String carName : carNameArray) {
            InputValidator.validateCarName(carName);
        }

        List<Car> carList = Arrays.stream(carNameArray)
                .map(Car::new)
                .toList();

        return carList;
    }
}
