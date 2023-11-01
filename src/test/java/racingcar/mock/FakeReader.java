package racingcar.mock;

import racingcar.io.input.Reader;

public class FakeReader implements Reader {

    private final String input;

    public FakeReader(String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return this.input;
    }

}
