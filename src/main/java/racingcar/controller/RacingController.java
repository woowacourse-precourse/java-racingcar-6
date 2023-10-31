package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.validation.InputValidator;
import racingcar.view.ConsoleOutput;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService, OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void run() {
        racingGameStart();
    }

    private void racingGameStart() {
        List<String> carNames = getCarNames();
        Cars cars = new Cars(carNames);

        int tries = getTries();
        racingGame(cars, tries);
    }

    private List<String> getCarNames() {
        ConsoleOutput.displayGetCarNameMessage();
        String input = inputView.getCarNames();
        List<String> carNames = racingService.stringToList(input);
        InputValidator.isLengthGreaterThanFive(carNames);
        return carNames;
    }

    private int getTries() {
        ConsoleOutput.displayTryMessage();
        int tries = inputView.getTries();
        InputValidator.isGreaterThanZero(tries);
        ConsoleOutput.printNewLine();
        return tries;
    }

    private void racingGame(Cars cars, int tries) {
        ConsoleOutput.displayRaceResultMessage();
        IntStream.range(0,tries)
                .forEach(i -> cars.playGame());
        outputView.printGameResult(cars.getWinner());
    }
}
