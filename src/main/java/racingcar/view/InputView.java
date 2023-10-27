package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.CarNameValidator;

public class InputView {
    CarNameValidator carNameValidator = new CarNameValidator();
    public String input() {
        String carNames = Console.readLine();
        if(carNameValidator.check(carNames)){
            return carNames;
        }
        throw new IllegalArgumentException();
    }
}
