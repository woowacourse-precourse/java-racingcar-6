package racingcar.global.utils.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.global.utils.constant.OutputType;

public class ConsoleUtil {

    private static final String SPLITTER = ", ";

    private ConsoleUtil() {
    }

    public static void commonOutputLine(String output) {
        System.out.println(output);
    }

    public static void outputWinners(List<String> winners) {
        String result = String.join(SPLITTER, winners);
        System.out.println(OutputType.OUTPUT_WINNER.getComment() + result);
    }

    public static String input() {
        return Console.readLine();
    }
}
