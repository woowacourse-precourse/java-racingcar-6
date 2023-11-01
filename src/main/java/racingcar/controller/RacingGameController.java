package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.round.GameRound;
import racingcar.utils.RandomNumber;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private Cars cars;
    private GameRound gameRound;
    private final RandomNumber randomNumber = new RandomNumberGenerator();

    public void run() {
        initCarNames();
        initGameRound();

        OutputView.printGameResultMessage();
        printGameContinuable();


    }

    private void printGameContinuable() {
        while (gameRound.isContinuable()) {
            playGame();
            OutputView.printCarStatuses(cars.getCarStatus());
        }
    }

    private void playGame() {
        cars.checkCarIsMovable();
        gameRound.isCountDecrease();
    }


//    private void announceWinners() {
//        final List<String> winnerNames = gameService.getWinnerNames();
//        outputView.printMessageOfWinners(winnerNames);
//    }


    private void initCarNames() {
        cars = new Cars(InputView.readCarName(), randomNumber);
    }

    private void initGameRound() {
        gameRound = new GameRound(InputView.readGameRound());
    }
}
