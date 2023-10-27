package racingcar.component.output;

import static strings.Strings.LINE_BREAK;

import racingcar.component.Component;

public final class ExecutionResultComponent implements Component {

    private static final String TEXT = LINE_BREAK + "실행 결과" + LINE_BREAK;

    @Override
    public String render() {
        return TEXT;
    }
}
