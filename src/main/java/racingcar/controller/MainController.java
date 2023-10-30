package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.view.Output;

public class MainController {

    private RacingController racingController = new RacingController();

    public void run() {
        Output.printInputCarNameInstruction();
        List<String> carNames = Input.getCarNames();

        Output.printExecutionCountQuestion();
        int NumberOfExecutions = Input.getInteger();

        List<Car> winners = racingController.race(carNames, NumberOfExecutions);
        Output.printWinners(winners);

    }
}
