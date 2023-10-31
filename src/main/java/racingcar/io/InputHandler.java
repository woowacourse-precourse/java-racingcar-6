package racingcar.io;

import static racingcar.constant.Constants.INPUT_SEPARATOR;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.util.StringManipulator;
import racingcar.util.Validator;

public class InputHandler {
    public static String readLine() {
        return Console.readLine();
    }
    public static List<String> convertCarNames(String carNamesWithSeparator) {
        String[] carNameGroup = StringManipulator.splitSeparator(carNamesWithSeparator, INPUT_SEPARATOR);
        Validator.checkValidCarNames(carNameGroup);
        List<String> carNames = StringManipulator.toList(carNameGroup);

        return carNames;
    }

    public static int convertTrialNumber(String trialNum) {
        Validator.checkValidTrialNumber(trialNum);
        return Integer.parseInt(trialNum);
    }
}
