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
        cars = new Cars(InputView.inputNames());
        racingRound = new RacingRound(InputView.inputRound());
    }

    private void playRound() {
        OutputView.printExecutionResultMessage();

        IntStream.range(0, racingRound.getRound()).forEach(i -> {
            moveCars();
            displayCars();
            OutputView.printBlankLine();
        });
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_INPUT_RANGE, Constants.MAX_INPUT_RANGE);
    }

    private void moveCars() {
        cars.getCarList().forEach(car -> car.moveForward(generateRandomNumber()));
    }

    private void displayCars() {
        cars.getCarList().forEach(OutputView::printCarNameAndPosition);
    }

    private void showWinners() {
        List<String> winners = cars.findWinners();
        OutputView.printWinners(winners);
    }
}
