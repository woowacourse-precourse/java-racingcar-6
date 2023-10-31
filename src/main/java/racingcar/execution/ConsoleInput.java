package racingcar.execution;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements GameInput {
    @Override
    public String receiveInput() {
        return Console.readLine();
    }
}
