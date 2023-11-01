package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import racingcar.enums.ErrorMessages;
import racingcar.enums.Instructions;

public class InputView {
    public String readCarNames() {
        System.out.println(Instructions.CAR_NAMES.getInstruction());
        String input = Console.readLine();
        return input;
    }

    public int readCount() {
        System.out.println(Instructions.TRY_COUNT.getInstruction());
        String input = Console.readLine();
        validateCount(input);
        return Integer.parseInt(input);
    }

    private void validateCount(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new IllegalArgumentException(ErrorMessages.ONLY_NUMBER.getMessage());
        }
    }
}
