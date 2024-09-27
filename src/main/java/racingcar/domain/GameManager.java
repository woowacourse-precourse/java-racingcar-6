package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.view.InputView.INPUT_VIEW;
import static racingcar.view.OutputView.OUTPUT_VIEW;

public class GameManager {
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
        OUTPUT_VIEW.printGameStartMessage();
    }

    private void gameRunning() {
        IntStream.range(0, attempts).forEach(i -> playSingeRound());
    }

    private void gameEnd() {
        List<String> winnerCarNames = raceCars.determineWinner();
        OUTPUT_VIEW.printWinners(winnerCarNames);
    }

    private Cars initRaceCars() {
        List<String> carNames = INPUT_VIEW.readCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private int initAttempts() {
        return INPUT_VIEW.readAttempts();
    }

    private void playSingeRound() {
        raceCars.moveCars();
        OUTPUT_VIEW.printRoundResult(raceCars);
    }
}
