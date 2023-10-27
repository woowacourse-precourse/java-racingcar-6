package racingcar.component.in;

import common.Component;

public final class MaxRoundComponent implements Component {

    private static final String TEXT = "시도할 회수는 몇회인가요?\n";

    @Override
    public String render() {
        return TEXT;
    }
}
