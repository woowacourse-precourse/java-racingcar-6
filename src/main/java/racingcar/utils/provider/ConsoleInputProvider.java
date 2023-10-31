package racingcar.utils.provider;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String getInput() {
        return Console.readLine();
    }
}
