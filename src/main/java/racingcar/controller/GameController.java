package racingcar.controller;

import java.util.List;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameService gameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        initializeGame();
        playGame();
        determineWinners();
    }

    private void initializeGame() {
        String[] carNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();
        this.gameService = GameService.startGame(carNames, attemptCount);
    }

    private void playGame() {
        outputView.printGameResultMessage();

        while (gameService.isGameProgress()) {
            List<Car> racingCars = gameService.attemptDrive();
            racingCars.forEach(this::printAttemptResult);
            outputView.printNewLine();
        }
    }

    private void printAttemptResult(Car car) {
        outputView.printCarNameAndPosition(car.getName(), car.getPosition());
    }

    private void determineWinners() {
        Winners winners = gameService.findWinners();
        outputView.printWinners(getWinnersName(winners));
    }

    private List<String> getWinnersName(Winners winners) {
        return winners.getWinners().stream()
                .map(Car::getName)
                .toList();
    }
}
