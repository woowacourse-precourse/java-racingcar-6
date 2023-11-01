package racingcar.view.input;

public class DoubleConsoleService implements ConsoleService {
    private final String value;

    public DoubleConsoleService(String value) {
        this.value = value;
    }

    @Override
    public String readLine() {
        return value;
    }

    @Override
    public void close() {
    }
}
