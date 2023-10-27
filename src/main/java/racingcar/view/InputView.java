package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.CarNameInputErrorException;
import racingcar.exception.InputErrorException;
import racingcar.exception.TryCountInputErrorException;

public class InputView {
    InputErrorException carNameInputErrorException = new CarNameInputErrorException();
    InputErrorException tryCountInputErrorException = new TryCountInputErrorException();

    public String readCarNames() {
        String input = Console.readLine();
        carNameInputErrorException.checkUserInputValidate(input);
        return input;
    }
}
