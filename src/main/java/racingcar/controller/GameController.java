package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.PlayCount;
import racingcar.model.RandomNumber;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumber randomNumber;

    public GameController(final InputView inputView, final OutputView outputView, final RandomNumber randomNumber) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.randomNumber = randomNumber;
    }

    public void play() {
        outputView.askCarNames();
        Cars playCars = Cars.from(inputView.receiveCarNames());
        
        outputView.askPlayCount();
        PlayCount playCount = PlayCount.from(inputView.receivePlayCount());

        outputView.printGameEnd();

        while (!playCount.isPlayEnd()) {
            playCars.race(randomNumber);
            printCarsStatus(playCars);
            playCount.endOneRound();
        }

        printWinners(playCars);
    }

    private void printCarsStatus(final Cars cars) {
        List<String> carsStatus = cars.collectEachStatus();
        outputView.printCarsStatus(carsStatus);
    }

    private void printWinners(final Cars cars) {
        List<String> winners = cars.collectWinners();
        outputView.printWinners(winners);
    }
}
