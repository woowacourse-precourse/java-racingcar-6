package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.InputDataValidator.validateHasSpace;
import static racingcar.util.InputDataValidator.validateIsInteger;

import java.util.List;

public class InputView {
    String input = "";

    public String inputCars() {
        input = readLine();
        validateHasSpace(input);

        return input;
    }

    public Integer inputCountNumber() {
        input = readLine();
        validateIsInteger(input);

        return Integer.parseInt(input);
    }
}
