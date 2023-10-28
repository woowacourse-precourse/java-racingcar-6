package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {

    public static String promptLine(Object message) {
        System.out.println(message.toString());
        return Console.readLine();
    }
}
