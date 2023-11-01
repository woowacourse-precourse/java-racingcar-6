package racingcar.view.component.input;

import racingcar.view.component.Component;

public final class MaxRoundComponent implements Component {

    private static final String TEXT = "시도할 회수는 몇회인가요?\n";

    @Override
    public String render() {
        return TEXT;
    }
}
