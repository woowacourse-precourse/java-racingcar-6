package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        String carNames = Console.readLine();
        InputValidator.validateDivisionCarNames(carNames);
        return carNames;
    }
}
