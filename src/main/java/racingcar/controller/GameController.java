package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.CommonSymbol;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public GameController() {
    }

    public void startGame() {
        List<String> names = readCarNames();
        Race race = new Race(createCarsFromNames(names));
        int attemptCount = readAttemptCount();

        OutputView.printExecutionResultMessage();

        for (int i = 0; i < attemptCount; i++) {
            race.forwardAllCarsWithRandom();
            race.displayAllCarsPosition();
        }

        race.displayWinnerNames();
    }

    private int readAttemptCount() {
        String inputCount = InputView.readAttemptCount();

        InputValidator.validateNumericInput(inputCount);

        return Integer.parseInt(inputCount);
    }

    private List<String> readCarNames() {
        String inputNames = InputView.readCarNames();

        return Arrays.stream(inputNames.split(CommonSymbol.SYMBOL_COMMA))
                .collect(Collectors.toList());
    }

    private List<Car> createCarsFromNames(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
