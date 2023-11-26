package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Cars raceCars;
    private final int attempts;

    public GameManager() {
        raceCars = initRaceCars();
        attempts = initAttempts();
    }

    public void run() {
        gameStart();
        gameRunning();
        gameEnd();
    }

    private void gameStart() {
        outputView.printGameStartMessage();
    }

    private void gameRunning() {
        IntStream.range(0, attempts).forEach(i -> playSingeRound());
    }

    private void gameEnd() {
        List<String> winnerCarNames = raceCars.determineWinner();
        outputView.printWinners(winnerCarNames);
    }

    private Cars initRaceCars() {
        List<String> carNames = inputView.readCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private int initAttempts() {
        return inputView.readAttempts();
    }

    private void playSingeRound() {
        raceCars.moveCars();
        outputView.printRoundResult(raceCars);
    }
}
