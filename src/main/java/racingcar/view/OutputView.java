package racingcar.view;

import racingcar.message.ViewMessage;

import java.util.List;

public class OutputView {
    public void printNameMessage() {
        System.out.println(ViewMessage.PRINT_NAME);
    }

    public void printTryNumberMessage() {
        System.out.println(ViewMessage.PRINT_TRY_NUMBER);
    }

    public void printRunResultMessage() {
        printChangeLine();
        System.out.println(ViewMessage.PRINT_RUN_RESULT);
    }

    public void printChangeLine() { System.out.print(ViewMessage.PRINT_CHANGE_LINE); }

    public void printRunResult(String name, int moveForwardCount) {
        System.out.printf("%s : %s%s", name , ViewMessage.PRINT_CHAR.repeat(moveForwardCount), ViewMessage.PRINT_CHANGE_LINE);
    }

    public void printWinner(List<String> winners) {
        System.out.print(ViewMessage.PRINT_WINNER);

        for(String winner : winners) {
            if(winners.indexOf(winner) >= 1) {
                System.out.print(", ");
            }
            System.out.print(winner);
        };
    }

    public void printRestartOrExitMessage() {
        printChangeLine();
        System.out.println(ViewMessage.PRINT_RESTART_OR_EXIT);
    }
}