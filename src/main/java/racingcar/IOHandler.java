package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {
    public void printComment(String comment) {
        System.out.println(comment);
    }

    public String readConsoleInput() {
        return Console.readLine();
    }
}
