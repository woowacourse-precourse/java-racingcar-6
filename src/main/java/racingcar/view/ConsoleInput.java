package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {
    @Override
    public String readCarNameLine() {
        return Console.readLine();
    }

    @Override
    public String readTotalRoundLine() {
        return Console.readLine();
    }
}
