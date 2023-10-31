package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    static public String requestInput(Message requestMessage) {
        printlnMessage(requestMessage);
        return Console.readLine();
    }

    static public void printMessage(Message message) {
        message.print();
    }

    static public void printlnMessage(Message message) {
        message.println();
    }

    static public void printlnMessage(String message) {
        System.out.println(message);
    }
}
