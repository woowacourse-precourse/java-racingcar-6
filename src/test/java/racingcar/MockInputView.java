package racingcar;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MockInputView implements InputView {
    private List<String> inputArguments = new ArrayList<>();
    private Iterator<String> iterator;

    public MockInputView(String... args) {
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
