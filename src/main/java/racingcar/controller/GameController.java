package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.car.Car;
import racingcar.util.InputUtil;
import racingcar.util.RandomUtil;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static java.lang.Integer.parseInt;
import static racingcar.view.constant.SystemMessage.*;

public class GameController {

    public void run() {
        String carNames = readCarNames();
        int tryCount = readTryCount();
        Race race = new Race(generateCars(carNames));

        printRaceStatus(race, tryCount);
        printRaceWinner(race);
    }

    private void printRaceWinner(Race race) {
        OutputView.printMessage(String.format(RACE_WINNERS.getMessage(), race.getWinnerString()));
    }

    private void printRaceStatus(Race race, int tryCount) {
        OutputView.printMessage(RACE_STATUS.getMessage());
        for (int i = 0; i < tryCount; i++) {
            race.moveEachCar(RandomUtil.getRandomNumber());
            OutputView.printMessage(race.getStatusString());
        }
    }

    private List<Car> generateCars(String carNames) {
        return InputUtil.convertInputStringToList(carNames)
                .stream()
                .map(Car::new)
                .toList();
    }

    private String readCarNames() {
        OutputView.printMessage(READ_CAR_NAMES.getMessage());
        String carNames = InputView.read();
        CarNameValidator.validateForInputString(carNames);

        return carNames;
    }

    private int readTryCount() {
        OutputView.printMessage(READ_TRY_COUNT.getMessage());
        String tryCount = InputView.read();
        TryCountValidator.validate(tryCount);

        return parseInt(tryCount);
    }
}
