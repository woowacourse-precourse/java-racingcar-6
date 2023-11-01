package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RemainRacingCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class PlayRacingGameImpl implements PlayRacingGame {

    FindWinners findWinners;
    PlayEachRacingGame playEachRacingGame;
    ValidCars validCars;
    ValidRacingCount validRacingCount;
    OutputView outputView;

    InputView inputView;

    public PlayRacingGameImpl(FindWinners findWinners, PlayEachRacingGame playEachRacingGame, ValidCars validCars,
                              ValidRacingCount validRacingCount, OutputView outputView, InputView inputView) {
        this.findWinners = findWinners;
        this.playEachRacingGame = playEachRacingGame;
        this.validCars = validCars;
        this.validRacingCount = validRacingCount;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void playRacingGame() {
        List<Car> cars = validCars.getValidCars();

        RemainRacingCount remainRacingCount = validRacingCount.getValidRacingCount();
        outputView.printResult();
        while (remainRacingCount.isRemainRacingCount()) {
            remainRacingCount.minusRemainRacingCount();
            cars = playEachRacingGame.getPlayEachRacingGame(cars);
        }
        List<String> winners = findWinners.getWinner(cars);
        outputView.printWinner(winners);

        inputView.close();

    }
}
