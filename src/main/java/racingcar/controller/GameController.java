package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.car.Car;
import racingcar.util.InputUtil;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static java.lang.Integer.*;

public class GameController {

    public void run() {
        String carNames = readCarNames();
        int tryCount = readTryCount();
        Race race = new Race(generateCars(carNames));

        printRaceStatus(tryCount, race);
        printRaceWinner(race);
    }

    private static void printRaceWinner(Race race) {
        OutputView.printMessage("최종 우승자 : " + race.getWinnerString());
    }

    private static void printRaceStatus(int tryCount, Race race) {
        OutputView.printMessage("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            race.moveEachCar();
            OutputView.printMessage(race.getStatusString());
        }
    }

    private static List<Car> generateCars(String carNames) {
        return InputUtil.convertInputStringToList(carNames)
                .stream()
                .map(Car::new)
                .toList();
    }

    private static String readCarNames() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = InputView.read();
        CarNameValidator.validateForInputString(carNames);

        return carNames;
    }

    private static int readTryCount() {
        OutputView.printMessage("시도할 회수는 몇회인가요?");
        String tryCount = InputView.read();
        TryCountValidator.validate(tryCount);

        return parseInt(tryCount);
    }
}
