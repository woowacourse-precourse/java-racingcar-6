package racingcar.controller;

import racingcar.domain.Race;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<String> carNames = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();

        Race race = new Race(carNames, RandomNumberGenerator.getInstance());

        outputView.start();
        for (int i = 0; i < tryCount; i++) {
            race.process();
            outputView.printStanding(race.getCars());
        }
        outputView.printResult(race.winners());
    }

}
