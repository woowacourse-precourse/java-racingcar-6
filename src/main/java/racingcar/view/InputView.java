package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.InputParser;
import racingcar.validation.InputValidation;

public class InputView {

    public List<String> inputCars() {
        String input = Console.readLine();
        return InputValidation.validateCars(input);
    }
}
