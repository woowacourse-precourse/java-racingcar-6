package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Cars cars;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        cars = new Cars();
    }

    public void start() {
        inputView.printRequestCarName();
        cars.addCar(Console.readLine());
        inputView.printRequestAttemptsNumber();
        AttemptCount attemptCount = new AttemptCount(Console.readLine());
        outputView.printRacingStartMessage();
    }
}
