package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

public class RacingGameController implements GameController {
    private final OutputManager outputManager;
    private final InputManager inputManager;
    private final RacingGame racingGame;

    public RacingGameController(OutputManager outputManager, InputManager inputManager, RacingGame racingGame) {
        this.outputManager = outputManager;
        this.inputManager = inputManager;
        this.racingGame = racingGame;
    }

    @Override
    public void setUp() {
        setUpCars();
        setUpGameCount();
    }

    @Override
    public void playOneTurn() {
        racingGame.playOneTurn();
        outputManager.printCarsPosition(racingGame.getAllCarsTrail());
    }

    @Override
    public void playGame() {
        outputManager.printResultNoticeMessage();
        IntStream.range(0, racingGame.getGameCount()).forEach(i -> playOneTurn());
    }

    @Override
    public void showResult() {
        List<Car> winners = racingGame.findWinners();
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        outputManager.printWinners(winnerNames);
    }

    @Override
    public void gameOver() {
        outputManager.printGameOver();
    }

    public List<String> getCarNames() {
        outputManager.printRequestCarNameInputMessage();
        List<String> carNames = inputManager.getStringListSplitByComma();
        checkCarNameIsValid(carNames);
        return carNames;
    }

    public void setUpCars() {
        List<String> carNames = getCarNames();
        List<Car> cars = Car.createCars(carNames);
        racingGame.setCars(cars);
    }

    public void setUpGameCount() {
        outputManager.printRequestGameCountInputMessage();
        int gameCount = inputManager.getOnePositiveNumber();
        racingGame.setGameCount(gameCount);
    }

    public void checkCarNameIsValid(List<String> carNames) {
        if (inputManager.hasDuplicateInList(carNames) ||
                !inputManager.isStringLengthValidInList(carNames, RacingGame.CAR_NAME_MAX_LENGTH) ||
                !inputManager.isStringNumValidInList(carNames, RacingGame.CAR_MAX_NUM)
        ) {
            throw new IllegalArgumentException();
        }
    }
}
