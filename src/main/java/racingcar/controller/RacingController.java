package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private Race race;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String carNames = inputView.getInputCarName();
        String count = inputView.getInputCount();
        this.race = new Race(carNames, count);
        printResults();
    }

    public void race() {
        race.moveCars();
        outputView.printResult(race.getCars());
    }

    private void printRaceResult() {
        IntStream.range(0, race.getMoveCount())
            .forEach(i -> race());
    }

    public void printResults() {
        outputView.printOutputMessage();
        printRaceResult();
        outputView.printWinners(race.getWinnerNames());
    }
}
