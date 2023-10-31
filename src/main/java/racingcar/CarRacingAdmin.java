package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.console.RacingCarConsole;
import racingcar.policy.Policy;
import racingcar.validator.InputValidator;

public class CarRacingAdmin {
    private final InputValidator inputValidator;

    public CarRacingAdmin() {
        inputValidator = new InputValidator();
    }

    public void startRace() {
        String carNames = RacingCarConsole.readCarNames();
        List<Car> carList = getReadyCars(carNames);

        int iterationNumBer = RacingCarConsole.readIterationNumBer();
        inputValidator.validateIterationNumBer(iterationNumBer);

        Policy policy = new Policy();
        CarRacing carRacing = new CarRacing(carList, iterationNumBer, policy);
        CarRacingResult carRacingResult = carRacing.start();

        RacingCarConsole.printCarRacingResult(carRacingResult);
    }

    private List<Car> getReadyCars(String carNames) {
        inputValidator.validateCarNames(carNames);
        String[] carNameArray = carNames.split(",");
        for (String carName : carNameArray) {
            inputValidator.validateCarName(carName);
        }

        List<Car> carList = Arrays.stream(carNameArray)
                .map(Car::new)
                .toList();

        return carList;
    }
}
