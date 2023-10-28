package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RoundManager roundManager = new RoundManager();
    private final List<Car> raceCars;
    private final int attempts;

    public GameManager(){
        raceCars = initRaceCars();
        attempts = initAttempts();
    }

    public void run(){
        gameStart();
        gameRunning();
        gameEnd();
    }
    private void gameStart() {
        outputView.printGameStartMessage();
    }
    private void gameRunning() {
        IntStream.range(0,attempts).forEach(i -> playSingeRound());
    }
    private void gameEnd() {
        List<String> winnerCarNames = Referee.determineWinner(this.raceCars);
        outputView.printWinners(winnerCarNames);
    }

    private List<Car> initRaceCars(){
        List<String> carNames = inputView.getCarNames();
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int initAttempts(){
        return inputView.getAttempts();
    }

    private void playSingeRound(){
        roundManager.moveCars(raceCars);
        outputView.printRoundResult(raceCars);
    }
}
