package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private Race race;

    public void run() {
        String carNames = InputView.getInputCarName();
        String count = InputView.getInputCount();
        this.race = new Race(carNames, count);
        printResults();
    }

    public void race() {
        race.moveCars();
        OutputView.printResult(race.getCars());
    }

    private void printRaceResult() {
        IntStream.range(0, race.getMoveCount())
            .forEach(i -> race());
    }

    public void printResults() {
        OutputView.printOutputMessage();
        printRaceResult();
        OutputView.printWinners(race.getWinnerNames());
    }
}
