package racingcar.domain.game.controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.Trial;
import racingcar.domain.game.Winner;
import racingcar.domain.game.service.RacingGameService;
import racingcar.global.utils.Utils;
import racingcar.global.validator.InputValidator;
import racingcar.global.view.InputView;
import racingcar.global.view.OutputView;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        String carsUserInput = getUserInputWithValidation(OutputView::printCarNameInputMessage,
                InputValidator::validateNullOrEmptyInput);
        Cars cars = generateCars(carsUserInput);

        String trialUserInput = getUserInputWithValidation(OutputView::printTryCountInputMessage,
                InputValidator::validateNullOrEmptyInput,
                InputValidator::validateInputIsNumeric);
        Trial trial = new Trial(Utils.stringToInt(trialUserInput));

        startGame(cars, trial);
    }

    private void startGame(final Cars cars, final Trial tryCount) {
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
