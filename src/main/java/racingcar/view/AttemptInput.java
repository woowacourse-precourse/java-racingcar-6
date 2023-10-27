package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.AttemptsInputValidator;
import racingcar.validator.Validator;

public class AttemptInput implements Input {

    private static final String ASK_ATTEMPT_TIMES = "시도할 회수는 몇회인가요?";

    private final Validator validator = new AttemptsInputValidator();
    private final String attempts;

    public AttemptInput() {
        Output.printMessage(ASK_ATTEMPT_TIMES);
        attempts = Console.readLine();
        validate();
    }

    private void validate() {
        validator.validate(attempts);
    }

    public String readLine() {
        return attempts;
    }
}
