package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarController {

    public void start() {
        String userInput = askCarNames();
    }

    public String askCarNames() {
        return Console.readLine();
    }

}
