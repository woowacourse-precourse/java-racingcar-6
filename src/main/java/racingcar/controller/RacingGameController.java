package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.domain.RacingRound;
import racingcar.util.Constants;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private Cars cars;
    private RacingRound racingRound;

    public RacingGameController() {
    }

    public void playGame() {
        init();
        playRound();
        showWinners();
    }

    private void init() {
        cars = Cars.from(InputView.inputNames());
        racingRound = new RacingRound(InputView.inputRound());
    }

    private void playRound() {
        OutputView.printExecutionResultMessage();

        IntStream.range(0, racingRound.getRound()).forEach(i -> {
            cars.moveCars();
            displayCars();
            OutputView.printBlankLine();
        });
    }

    private void displayCars() {
        cars.getCarList().forEach(OutputView::printCarNameAndPosition);
    }

    private void showWinners() {
        List<String> winners = cars.findWinners();
        OutputView.printWinners(winners);
    }
}
