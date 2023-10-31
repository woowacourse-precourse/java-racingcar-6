package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.console.RacingCarConsole;
import racingcar.util.NumberGenerator;
import racingcar.util.Util;
import racingcar.validator.InputValidator;

public class CarRacingAdmin {
    private final InputValidator inputValidator;

    public CarRacingAdmin() {
        Util util = new Util();
        inputValidator = new InputValidator(util);
    }

    public void startRace() {
        String carNames = RacingCarConsole.readCarNames();
        List<Car> carList = getReadyCars(carNames);

        int iterationNumBer = RacingCarConsole.readIterationNumBer();
        inputValidator.validateIterationNumBer(iterationNumBer);

        CarRacing carRacing = new CarRacing(carList, iterationNumBer);
        NumberGenerator numberGenerator = new Util();
        CarRacingResult carRacingResult = carRacing.start(numberGenerator);

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
