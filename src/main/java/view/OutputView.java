package view;

import message.ViewMessage;

import java.util.List;

public class OutputView {
    public void printName() {
        System.out.println(ViewMessage.PRINT_NAME);
    }

    public void printTryNumber() {
        System.out.println(ViewMessage.PRINT_TRY_NUMBER);
    }

    public void printRunGame() {
        printChangeLine();
        System.out.println(ViewMessage.PRINT_RUN_GAME);
    }

    public void printChangeLine() { System.out.print(ViewMessage.PRINT_CHANGE_LINE); }

    public void printWinner(List<String> winners) {
        System.out.print(ViewMessage.PRINT_WINNER);

        for(String winner : winners) {
            if(winners.indexOf(winner) >= 1) {
                System.out.print(", ");
            }
            System.out.print(winner);
        };
    }

    public void printGameResult(String name, int moveForwardCount) {
        System.out.printf("%s : %s%s", name , ViewMessage.PRINT_CHAR.repeat(moveForwardCount), ViewMessage.PRINT_CHANGE_LINE);
    }

    public void printRestartOrExit() {
        printChangeLine();
        System.out.println(ViewMessage.PRINT_RESTART_OR_EXIT);
    }
}