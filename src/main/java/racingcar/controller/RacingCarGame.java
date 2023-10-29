package racingcar.controller;

import java.util.List;
import racingcar.model.CarAccelerator;
import racingcar.model.Cars;
import racingcar.model.RacingCarGameJudgementSystem;
import racingcar.model.Round;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();

    public void play() {
        Cars cars = getCars();
        Round round = getRound();

        outputView.printGameResult();
        attemptUntilGameOver(cars, round);

        Winners winners = getWinners(cars);
        outputView.printWinnersOfGame(winners.getWinnerNames());
    }

    private Cars getCars() {
        List<String> carNames = getCarNames();
        return new Cars(carNames);
    }

    private List<String> getCarNames() {
        outputView.promptCarNames();
        return inputView.inputCarNames();
    }

    private Winners getWinners(Cars cars) {
        RacingCarGameJudgementSystem racingCarGameJudgementSystem = new RacingCarGameJudgementSystem();
        return racingCarGameJudgementSystem.judge(cars);
    }

    private Round getRound() {
        outputView.promptNumberOfGameAttempts();
        int numberOfGameAttempts = inputView.inputNumberOfGameAttempts();
        return new Round(numberOfGameAttempts);
    }

    private void attemptUntilGameOver(Cars cars, Round round) {
        while (round.hasNextRound()) {
            CarAccelerator carAccelerator = new CarAccelerator();
            cars.attemptToMoveCars(carAccelerator);
            List<String> carNames = cars.getCarNames();
            List<Integer> movingDistances = cars.getMovingDistances();
            outputView.printGameResultsPerAttempt(carNames, movingDistances);
            round.finishRound();
        }
    }
}
