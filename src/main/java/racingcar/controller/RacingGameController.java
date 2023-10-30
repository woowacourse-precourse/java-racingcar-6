package racingcar.controller;

import java.util.List;

import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.util.RandomNumberGenerator;
import racingcar.validation.NumberValidator;
import racingcar.validation.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final RacingGame racingGame = new RacingGame();
        initializeCar(racingGame);
        final int moveCount = initializeMoveCount();
        process(racingGame, moveCount);
    }

    private void process(final RacingGame racingGame, final int moveCount) {
        for (int count = 0; count < moveCount; count++) {
            racingGame.moveCar();
            printRacingResult(racingGame);
        }
        printRacingWinners(racingGame);
    }

    private void printRacingResult(final RacingGame racingGame) {
        final List<CarDto> result = racingGame.getResult();
        outputView.printRacingResult(result);
    }

    private void printRacingWinners(final RacingGame racingGame) {
        final List<CarDto> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }

    private void initializeCar(final RacingGame racingGame) {
        final String carName = inputView.readCarName();
        final String[] carNames = carName.split(",");
        for (final String name : carNames) {
            final Car car = new Car(name, RandomNumberGenerator.getInstance());
            racingGame.addCar(car);
        }
    }

    private int initializeMoveCount() {
        final String moveCount = inputView.readMoveCount();
        final Validator validator = NumberValidator.getInstance();
        validator.validate(moveCount);
        return Integer.parseInt(moveCount);
    }
}
