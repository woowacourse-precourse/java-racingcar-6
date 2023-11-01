package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {
    public void printComment(String message) {
        System.out.println(message);
    }

    public String readConsoleInputWithMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
