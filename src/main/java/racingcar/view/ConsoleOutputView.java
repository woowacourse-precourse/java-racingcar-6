package racingcar.view;

public class ConsoleOutputView implements OutputView {

    @Override
    public void print(String string) {
        System.out.print(string);
    }

}
