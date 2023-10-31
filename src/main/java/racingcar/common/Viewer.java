package racingcar.common;

import camp.nextstep.edu.missionutils.Console;

public abstract class Viewer<T> {

    public abstract T interact();

    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    public void println(Message message) {
        System.out.println(message.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }

    protected String input(Message message) {
        println(message);
        return Console.readLine();
    }

    protected String input() {
        return Console.readLine();
    }
}
