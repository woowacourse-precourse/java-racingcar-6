package racingcar;

import racingcar.util.TypeConvertor;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램

    }

    private static InputView inputView() {
        return new InputView(new TypeConvertor());
    }
}
