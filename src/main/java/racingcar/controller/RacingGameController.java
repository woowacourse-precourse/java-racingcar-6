package racingcar.controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameResult;
import racingcar.domain.RacingGameService;
import racingcar.domain.Winner;
import racingcar.utils.Utils;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        String carsUserInput = getUserInputWithValidation(OutputView::printCarNameInputMessage,
                InputValidator::validateNullOrEmptyInput);
        Cars cars = generateCars(carsUserInput);

        String tryCountUserInput = getUserInputWithValidation(OutputView::printTryCountInputMessage,
                InputValidator::validateNullOrEmptyInput,
                InputValidator::validateTryCount);
        int tryCount = Utils.stringToInt(tryCountUserInput);

        startGame(cars, tryCount);
    }

    private void startGame(final Cars cars, final int tryCount) {
        GameResult gameResult = racingGameService.startGame(cars, tryCount);
        OutputView.printRoundResult(gameResult.getResult());

        Winner winner = racingGameService.findWinner(cars);
        OutputView.printWinnerNames(winner.getWinnerNames());
    }

    // 제네릭과 가변인수 사용시 [unchecked] Possible heap pollution 발생 해서 어노테이션으로 안전을 보장
    @SafeVarargs
    private String getUserInputWithValidation(Runnable printMessage, Consumer<String>... validators) {
        printMessage.run();
        String userInput = InputView.getUserInput();
        for (Consumer<String> validator : validators) {
            validator.accept(userInput);
        }
        return userInput;
    }

    private Cars generateCars(String carsUserInput) {
        List<String> carNames = Utils.parseNames(carsUserInput);
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

}
