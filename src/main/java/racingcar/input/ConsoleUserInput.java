package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUserInput implements UserInput<String> {

    @Override
    public String input() {
        return Console.readLine();
    }
}
