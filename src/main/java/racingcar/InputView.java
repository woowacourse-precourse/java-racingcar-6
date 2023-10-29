package racingcar;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Map<String, String> CarNames() {
        OutputView.printRequestCar();
        Map<String, String> racingCars = InputConvertor.toMap(Console.readLine());
        return Validator.inputCarNames(racingCars);
    }

    public static int AttemptNumber() {
        OutputView.printRequestAttempt();
        return InputConvertor.toInt(Console.readLine());
    }
}
