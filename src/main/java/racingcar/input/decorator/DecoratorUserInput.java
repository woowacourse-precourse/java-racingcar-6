package racingcar.input.decorator;

import racingcar.input.UserInput;

public abstract class DecoratorUserInput<T> implements UserInput<T> {
    protected final UserInput<T> userInput;

    public DecoratorUserInput(UserInput<T> userInput) {
        this.userInput = userInput;
    }
}
