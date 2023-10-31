package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static String inputCarNames() {
        UserOutput.ConsoleOutInputNames();
        return Console.readLine();
    }

    public static String inputExecutionCount() {
        UserOutput.consoleOutInputExecutionCnt();
        return Console.readLine();
    }
}
