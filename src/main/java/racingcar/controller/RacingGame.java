package racingcar.controller;

import racingcar.models.GameStatus;
import racingcar.service.Referee;
import racingcar.view.InputView;

import java.util.List;

public class RacingGame {

    private final Referee referee = new Referee();

    public void start() {
        List<String> carNames = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        referee.addCars(carNames);
        referee.startGame(tryCount);

        List<GameStatus> gameStatuses = referee.getGameStatuses();
        printGameStatus(gameStatuses);
        printGameWinners();
    }

    private void printGameWinners() {
        System.out.println("최종 우승자 : " + String.join(", ", referee.getWinners()));
    }

    private void printGameStatus(List<GameStatus> gameStatus) {
        gameStatus.forEach(System.out::println);
    }
}
