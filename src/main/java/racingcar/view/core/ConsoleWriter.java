package racingcar.view.core;

public sealed class ConsoleWriter permits InputView, OutputView {

    protected void print(final Object data) {
        System.out.print(data);
    }

    protected void println(final Object data) {
        System.out.println(data);
    }

    protected void newLine() {
        System.out.println();
    }

}
