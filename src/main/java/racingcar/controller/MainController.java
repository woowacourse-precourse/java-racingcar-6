package racingcar.controller;

import java.util.List;
import racingcar.view.Input;
import racingcar.view.Output;

public class MainController {

    private RacingController racingController = new RacingController();
    public void run(){
        Output.printInputCarNameInstruction();
        List<String> carNames = Input.getCarNames();

        Output.printExecutionCountQuestion();
        int NumberOfExecutions = Input.getInteger();

        racingController.race(carNames, NumberOfExecutions);
    }
}
