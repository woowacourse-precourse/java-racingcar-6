package racingcar.generator;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputGenerator implements InputGenerator{

    @Override
    public String getInputNames() {
        return Console.readLine();
    }

    @Override
    public String getInputNumber() {
        return Console.readLine();
    }
}
