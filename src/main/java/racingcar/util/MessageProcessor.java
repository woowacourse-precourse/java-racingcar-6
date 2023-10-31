package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class MessageProcessor {
    public MessageProcessor() {
    }

    public void print(String message) {
        System.out.print(message);
    }

    public String getInput() {
        return Console.readLine();
    }
}
