package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Validator;

public class InputView {

    Validator validator = new Validator();

    public String inputCarString() {
        String userInput = Console.readLine();

        return userInput;
    }

    public String inputTryCount() {
        String userInput = Console.readLine();

        return userInput;
    }


}
