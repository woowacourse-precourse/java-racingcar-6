package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameConsole implements GameConsole {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
