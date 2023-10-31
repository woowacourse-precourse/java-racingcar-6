package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.RoundNumber;
import racingcar.util.Utils;
import racingcar.view.InputView;

import java.io.InputStream;
import java.util.stream.IntStream;

public class GameController {
    CarList carList;
    RoundNumber roundNumber;

    public GameController() {
        initializeGame();
        startGame();
        printResult();
    }

    public void initializeGame() {
        this.carList = new CarList(InputView.requestRacingCarNames());
        this.roundNumber = new RoundNumber(InputView.requestRepetitionNumber());
    }

    public void startGame() {
        IntStream.range(0, roundNumber.roundNumber).forEach(i -> carList.raceOneRound(carList));
    }

    public void printResult() {
        carList.printFinalResult(carList);
    }
}
