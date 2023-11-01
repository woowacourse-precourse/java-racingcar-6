package racingcar;

import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER;
import static racingcar.constant.PrintMessage.INPUT_NUMBER_OF_ATTEMPTS;
import static racingcar.constant.PrintMessage.INPUT_RACING_CAR_NAME;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String RACING_CAR_NAME_SEPARATOR = ",";

    public String[] readCarNames() {
        System.out.println(INPUT_RACING_CAR_NAME);
        return Console.readLine().split(RACING_CAR_NAME_SEPARATOR);
    }

    public Integer readNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        return convertInputToInteger(Console.readLine());
    }

    private Integer convertInputToInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER);
        }
    }

}
