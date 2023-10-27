package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.PlayCount;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private PlayCount playCount;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        outputView.askCarNames();
        joinCars();
        
        outputView.askPlayCount();
        savePlayCount();

        outputView.printGameEnd();

        int round = 0;
        while (!playCount.isPlayEnd(round)) {
            cars.racing();
            round++;
            printCarsStatus();
        }

        printWinners();
    }

    private void joinCars() {
        String carNamesInput = inputView.receiveCarNames();
        cars = Cars.from(carNamesInput);
    }

    private void savePlayCount() {
        String countInput = inputView.receivePlayCount();
        playCount = PlayCount.from(countInput);
    }

    private void printCarsStatus() {
        List<String> carsStatus = cars.eachStatus();
        outputView.printCarsStatus(carsStatus);
    }

    private void printWinners() {
        List<String> winners = cars.collectWinners(playCount.getCount());
        outputView.printWinners(winners);
    }
}
