package racingcar.Console;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String receiveCarNames() {
        Output.printInputCarNames();
        return Console.readLine();
    }

    public static String receiveGameTryCounts() {
        Output.printInputGameTryCounts();
        return Console.readLine();
    }
}
