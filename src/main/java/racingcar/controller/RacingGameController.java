package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
public class RacingGameController {
    public String[] getInputCarNames() {
        return Console.readLine().trim().split(",");
    }

    public Integer getInputRepeatCount() {
        return Integer.parseInt(Console.readLine().trim());
    }
}
