package racingcar.input;

import static racingcar.constant.MessageConstant.CAR_NAME_INPUT_MESSAGE;
import static racingcar.constant.MessageConstant.TOTAL_ROUND_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;
import java.util.List;


public class Input {
    private static String inputString(String input) {
        System.out.print(input);
        return Console.readLine();
    }

    public static List<String> inputCarName() {
        String input = inputString(CAR_NAME_INPUT_MESSAGE.getMessage());

        List<String> splitInput = Validator.validateCarNameInput(input);

        splitInput.forEach(Validator::validateCheckCarName);

        return splitInput;
    }

    public static int inputTotalTurn() {
        String input = Input.inputString(TOTAL_ROUND_INPUT_MESSAGE.getMessage());

        Validator.validateTotalTurnInput(input);

        return Integer.parseInt(input);
    }
}
