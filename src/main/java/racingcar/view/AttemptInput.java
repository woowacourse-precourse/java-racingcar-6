package racingcar.view;

import racingcar.validator.AttemptInputValidator;
import racingcar.validator.Validator;

public class AttemptInput implements Input {

    private static final String ASK_ATTEMPT_TIMES = "시도할 회수는 몇회인가요?";

    private final Validator validator = new AttemptInputValidator();
    private final String attempts;

    public AttemptInput() {
        Output.printMessage(ASK_ATTEMPT_TIMES);
        attempts = ConsoleInput.readLine();
        validate();
    }

    private void validate() {
        validator.validate(attempts);
    }

    public String readLine() {
        return attempts;
    }
}
