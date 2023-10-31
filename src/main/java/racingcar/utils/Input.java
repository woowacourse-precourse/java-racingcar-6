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

    public static Long inputGameCount() {
        Output.askGameCount();
        String gameCount = inputString();
        ValidateInput.validateGameCount(gameCount);
        return Converter.convertStringToLong(gameCount);
    }

    private static String inputString() {
        return Console.readLine();
    }
}
