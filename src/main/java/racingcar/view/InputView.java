package racingcar.view;
import camp.nextstep.edu.missionutils.Console;

import racingcar.exception.RacingException;
public class InputView {
    RacingException racingException = new RacingException();
    public String readCarName() {
        String carNames = Console.readLine();
        racingException.validateCarNameLen(carNames);
        racingException.validateLastCharIsComma(carNames);
        racingException.validateIsNullAfterComma(carNames);
        racingException.validateCommaAfterComma(carNames);
        return carNames;
    }
}
