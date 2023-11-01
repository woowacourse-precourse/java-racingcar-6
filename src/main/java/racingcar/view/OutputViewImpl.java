package racingcar.view;

public class OutputViewImpl implements OutputView {
    private static final OutputViewImpl instance = new OutputViewImpl();

    private OutputViewImpl() {}

    public static OutputViewImpl getInstance() {
        return instance;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}