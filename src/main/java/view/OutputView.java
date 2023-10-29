package view;
import message.ViewMessage;

public class OutputView {
    public void printName() {
        System.out.println(ViewMessage.PRINT_NAME);
    }

    public void printTryNumber() {
        System.out.println(ViewMessage.PRINT_TRY_NUMBER);
    }

    public void printGameResult() {
        System.out.println(ViewMessage.PRINT_GAME_RESULT);
    }
}