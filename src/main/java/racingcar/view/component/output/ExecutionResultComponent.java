package racingcar.view.component.output;

import static strings.util.Strings.LINE_BREAK;

import racingcar.view.component.Component;

public final class ExecutionResultComponent implements Component {

    private static final String TEXT = LINE_BREAK + "실행 결과" + LINE_BREAK;

    @Override
    public String render() {
        return TEXT;
    }
}
