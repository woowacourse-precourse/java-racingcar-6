package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class GameConsoleInputUtil implements ConsoleInputUtil {

    @Override
    public String input() {
        return Console.readLine();
    }
}
