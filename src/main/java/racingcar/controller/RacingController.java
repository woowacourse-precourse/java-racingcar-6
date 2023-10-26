package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showCarNamesInputMessage();
        String carNames = input.readCarNames();
    }
}
