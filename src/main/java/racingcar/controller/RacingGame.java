package racingcar.controller;

import java.util.List;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        OutputView.printStartMessage();
        List<String> carName = InputView.readCarName();

        Round round = new Round();
        round.generateCars(carName);

        OutputView.printTryNumMessage();
        int tryNumber = InputView.readTryNumber();

        play(tryNumber, round);
    }

    private void play(int tryNumber, Round round) {
        OutputView.printResultMessage();
    }
}
