package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static List<String> inputCarNames() {
        String inputCarNames = Console.readLine();
        return Validator.inputCarNames(inputCarNames);
    }

    public static int inputAttemptNumber() {
        return InputConvertor.toInt(Console.readLine());
    }
}
