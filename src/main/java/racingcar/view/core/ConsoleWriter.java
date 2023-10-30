package racingcar.view.core;

public sealed class ConsoleWriter permits InputView, OutputView {

    public void print(final Object data) {
        System.out.print(data);
    }

    public void println(final Object data) {
        System.out.println(data);
    }

    public void newLine() {
        System.out.println();
    }

}
