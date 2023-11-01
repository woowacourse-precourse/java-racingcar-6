package racingcar.view.component.input;

import racingcar.view.component.Component;

public final class NameComponent implements Component {

    private static final String TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

    @Override
    public String render() {
        return TEXT;
    }
}
