package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Judgment;
import racingcar.domain.Name;
import racingcar.domain.RepeatCount;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        Cars cars = setUpGame();
        RepeatCount repeatCount = startGame();
        Judgment judgment = new Judgment(cars, new RandomNumberGenerator());

        OutputView.printRacingResult();
    }

    private Cars setUpGame() {
        String names = InputView.inputCarNames();
        return new Cars(names);
    }

    private RepeatCount startGame() {
        int repeatCount = InputView.inputRepeatCount();
        return new RepeatCount(repeatCount);
    }
}
