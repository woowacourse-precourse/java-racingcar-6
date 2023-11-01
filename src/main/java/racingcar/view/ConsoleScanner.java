package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleScanner {
    public static String readCarName() {
        ConsolePrinter.printCarNameMessage();
        return Console.readLine();
    }

    public static String readRound() {
        ConsolePrinter.printRoundMessage();
        return Console.readLine();
    }
}
