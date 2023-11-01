package racingcar.input.decorator;

import racingcar.input.UserInput;

public class RepeatCountDecoratorUserInput extends DecoratorUserInput<Integer> {

    private static final String REPEAT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public RepeatCountDecoratorUserInput(UserInput<Integer> userInput) {
        super(userInput);
    }

    @Override
    public Integer input() {
        System.out.println(REPEAT_COUNT_INPUT_MESSAGE);
        final Integer repeatCount = userInput.input();
        System.out.println();
        return repeatCount;
    }
}
