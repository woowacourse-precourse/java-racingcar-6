package racingcar.component.output;

import racingcar.common.Component;

public final class ExecutionResultComponent implements Component {

    private static final String TEXT = "실행 결과\n";

    @Override
    public String render() {
        return TEXT;
    }
}
