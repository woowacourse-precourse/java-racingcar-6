package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCarNames() {
        String carNames = Console.readLine();
        // TODO validation
        return carNames;
    }

    public String inputTryCount() {
        String tryCount = Console.readLine();
        // TODO validation
        return tryCount;
    }
}
