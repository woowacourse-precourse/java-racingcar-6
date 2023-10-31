package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class RacingView {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public List<String> getCarNames() {
        outputView.printRaceStartingMessage();
        return inputView.getCarNames();
    }

    public int getTrials() {
        outputView.printGetTrialsMessage();
        return inputView.getTrials();
    }

    public void printRacingResult() {
        outputView.printRacingResult();
    }

    public void printEachTrialResult(List<Car> cars) {
        outputView.printEachTrialResult(cars);
    }

    public void printWinners(List<Car> winners) {
        outputView.printWinners(winners);
    }
}
