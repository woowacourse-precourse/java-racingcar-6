package racingcar;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Map<String, String> CarNames() {
        OutputView.printRequestCar();
        Map<String, String> inputCarNamesMap = InputConvertor.toMap(Console.readLine());
        return Validator.inputCarNames(inputCarNamesMap);
    }

    public static int AttemptNumber() {
        OutputView.printRequestAttempt();
        return InputConvertor.toInt(Console.readLine());
    }
}
