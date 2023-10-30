package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Prompt {

    public Prompt() {
    }


    public String input() {
        return Console.readLine();
    }

    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    public void println(Message message) {
        System.out.println(message.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
}
