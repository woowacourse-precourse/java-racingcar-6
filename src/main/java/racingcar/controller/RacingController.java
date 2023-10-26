package racingcar.controller;

import racingcar.view.Output;

public class RacingController {

    private final Output output = new Output();

    public void run() {
        output.showCarNamesInputMessage();
    }
}
