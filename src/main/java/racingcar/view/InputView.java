package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import static racingcar.Validator.Validator.*;


public class InputView {

    public InputView() {
    }
    public String carNames(){
        String input = Console.readLine();
        validateNotBlank(input);
        validateNotEndsWithComma(input);
        return input;
    }

}
