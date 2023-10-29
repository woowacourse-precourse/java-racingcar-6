package racingcar.view;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printMessage() {
        System.out.println();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
