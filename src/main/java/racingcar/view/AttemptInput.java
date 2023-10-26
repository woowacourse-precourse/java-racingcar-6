package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.AttemptNumber;
import racingcar.validator.AttemptsInputValidator;
import racingcar.validator.Validator;

public class AttemptInput implements Input{

    private final Validator validator = new AttemptsInputValidator();
    private final String attempts;

    public AttemptInput() {
        attempts = Console.readLine();
        validate();
    }

    private void validate() {
        validator.validate(attempts);
    }

    public AttemptNumber readLine() {
        return new AttemptNumber(Integer.parseInt(attempts));
    }
}
