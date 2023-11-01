package racingcar.mock;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MockInputView implements InputView {
    private static final MockInputView instance = new MockInputView();
    private List<String> inputArguments;
    private Iterator<String> iterator;

    private MockInputView() {
    }

    public static MockInputView getInstance() {
        return instance;
    }

    public void init(String... args) {
        inputArguments = new ArrayList<>();
        for (String arg : args) {
            inputArguments.add(arg);
        }
        iterator = inputArguments.iterator();
    }

    @Override
    public String readLine() {
        return iterator.next();
    }
}
