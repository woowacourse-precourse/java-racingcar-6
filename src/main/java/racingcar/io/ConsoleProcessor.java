package racingcar.io;

import static racingcar.io.ConsoleMessage.REQUEST_CAR_NAME;
import static racingcar.io.ConsoleMessage.REQUEST_LOOP_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleProcessor {

    public void closeConsole() {
        Console.close();
    }

    public String[] getCarNames() {
        System.out.println(REQUEST_CAR_NAME.getMessage());
        final String input = Console.readLine();
        return input.split(",");
    }

    public String getLoopCount() {
        System.out.println(REQUEST_LOOP_COUNT.getMessage());
        return Console.readLine();
    }

}
