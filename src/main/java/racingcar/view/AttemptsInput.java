package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.AttemptNumber;
import racingcar.validator.AttemptsInputValidator;
import racingcar.validator.Validator;

public class AttemptsInput implements Input{

    private final Validator validator = new AttemptsInputValidator();
    private final String attempts;

    public AttemptsInput() {
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
