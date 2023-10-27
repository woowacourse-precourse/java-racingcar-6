package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public static void inputCarNames() {
        String inputCarNames = Console.readLine();
        List<String> carNamesList = Validator.inputCarNames(inputCarNames);
    }

    public static void inputNumber() {
        int inputNumber = InputConvertor.toInt(Console.readLine());

    }
}
