package view;

import message.ViewMessage;

import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OutputView {
    public void printName() {
        System.out.println(ViewMessage.PRINT_NAME);
    }

    public void printTryNumber() {
        System.out.println(ViewMessage.PRINT_TRY_NUMBER);
    }

    public void printRunGame() {
        System.out.println(ViewMessage.PRINT_RUN_GAME);
    }

    public void printWinner() { System.out.println(ViewMessage.PRINT_WINNER);}

    public void printGameResult(String name, StringBuilder moveForwardCount) {
        System.out.printf("%s : %s%n", name , moveForwardCount);
    }

}