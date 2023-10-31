package racingcar.execution;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements GameInput {
    @Override
    public String scan() {
        return Console.readLine();
    }
}
