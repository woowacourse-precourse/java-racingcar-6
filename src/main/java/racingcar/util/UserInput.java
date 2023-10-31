package racingcar.util;

import racingcar.view.InputView;

public class UserInput {
    public static String[] getCarNames() {
        String[] carNames = InputView.setUserInput().split(",");
        return carNames;
    }
}
