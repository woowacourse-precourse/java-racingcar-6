package racingcar.io;

import static racingcar.io.ConsoleMessage.REQUEST_CAR_NAME;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleProcessor {

    public String[] registerCarNames() {
        System.out.println(REQUEST_CAR_NAME.getMessage());
        final String input = Console.readLine();
        return input.split(",");
    }

    public String getLoopCount() {
        System.out.println(REQUEST_LOOP_COUNT.getMessage());
        return Console.readLine();
    }

}
