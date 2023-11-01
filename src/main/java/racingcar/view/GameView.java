package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String requestInput(Message requestMessage) {
        printlnMessage(requestMessage);
        return Console.readLine();
    }

    public void printMessage(Message message) {
        message.print();
    }

    public void printlnMessage(Message message) {
        message.println();
    }

    public void printlnMessage(String message) {
        System.out.println(message);
    }
}
