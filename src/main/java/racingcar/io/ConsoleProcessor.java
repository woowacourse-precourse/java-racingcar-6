package racingcar.io;

import static racingcar.io.ConsoleMessage.REQUEST_CAR_NAME;
import static racingcar.io.ConsoleMessage.REQUEST_LOOP_COUNT;
import static racingcar.io.ConsoleMessage.RESPONSE_LOOP_RESULT;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;

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

    public void printRacingGameResult() {
        System.out.println(MessageFormat.format("\n{0}", RESPONSE_LOOP_RESULT.getMessage()));
    }

    public void printRoundScore(final String key, final int value) {
        String forwardAmount = "-".repeat(value);
        System.out.println(MessageFormat.format("{0} : {1}", key, forwardAmount));
    }

    public void printNewLine() {
        System.out.println();
    }
}
