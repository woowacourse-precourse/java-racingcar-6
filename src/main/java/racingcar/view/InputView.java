package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ConsoleMessage;

public class InputView {

    public String getPlayerNamesInput() {
        printConsoleMessage(ConsoleMessage.START_GAME.getMessage());
        return Console.readLine();
    }

    public String inputTryCount() {
        printConsoleMessage(ConsoleMessage.INPUT_TRY_COUNT.getMessage());
        return Console.readLine();
    }
    private void printConsoleMessage(String message) {
        System.out.println(message);
    }

}
