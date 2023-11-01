package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.StringValidateUtils;

class RepeatCountUserInput implements UserInput<Integer> {

    private static final String REPEAT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    RepeatCountUserInput() {
    }

    @Override
    public Integer input() {
        System.out.println(REPEAT_COUNT_INPUT_MESSAGE);
        final String userInput = Console.readLine();
        validate(userInput);
        System.out.println();
        return Integer.parseInt(userInput);
    }

    private void validate(final String userInput) {
        StringValidateUtils.validateEmptyString(userInput);
        validateNumber(userInput);
    }

    private void validateNumber(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
