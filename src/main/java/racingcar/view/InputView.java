package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public class InputView {

    public String readCarNames() {
        String carNames = Console.readLine();
        Validator.isBlankInput(carNames);
        Validator.isNullInput(carNames);
        return carNames;
    }

}
