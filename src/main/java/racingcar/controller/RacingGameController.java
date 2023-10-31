package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
public class RacingGameController {
    public String[] getInputCarNames() {
        return Console.readLine().trim().split(",");
    }

    public String getInputRepeatCount() {
        return Console.readLine().trim();
    }
}
