package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.WinnerFinder;
import racingcar.view.OutputView;

public class RacingController {

    private Game game;

    public void playGame(List<Car> cars, int attemptCount) {
        this.game = new Game(cars);
        OutputView.printResultMessage();
        playAllRounds(attemptCount);
        OutputView.printWinnerMessage(WinnerFinder.findWinners(game.getCarsDTO().getCars()));
    }

    private void playAllRounds(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            game.playOneRound();
            OutputView.printResult(game.getCarsDTO().getCars());
        }
    }
}
