package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        String carNames = Console.readLine();
        return carNames;
    }

    public String inputTryNumber() {
        String tryNumber = Console.readLine();
        return tryNumber;
    }
}