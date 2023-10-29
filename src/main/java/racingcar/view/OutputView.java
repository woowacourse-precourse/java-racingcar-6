package racingcar.view;

public class OutputView {
    public OutputView() {
    }

    public static OutputView getInstance() {

        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }
}
