package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String promptLine(Object message) {
        Output.println(message);
        return Console.readLine();
    }
}
