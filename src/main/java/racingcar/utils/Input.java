package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validate.ValidateInput;

public class Input {

    public static List<String> inputCarNames() {
        Output.askCarName();
        String carNames = inputString();
        ValidateInput.validateCarNames(carNames);
        return Converter.convertStringToList(carNames);
    }

    private static String inputString() {
        return Console.readLine();
    }
}
