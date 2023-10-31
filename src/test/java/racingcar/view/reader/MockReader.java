package racingcar.view.reader;

public class MockReader implements Reader {

    private static final String BLANK = "";

    private final String message;

    public MockReader(String message) {
        this.message = message;
    }

    public MockReader() {
        this(BLANK);
    }

    @Override
    public String read() {
        return message;
    }
}
