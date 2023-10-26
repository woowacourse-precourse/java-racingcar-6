package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NamesInputValidator;
import racingcar.validator.Validator;

public class NamesInput implements Input {

    private final Validator namesValidator = new NamesInputValidator();
    private final String names;

    public NamesInput() {
        names = Console.readLine();
        validate();
    }

    private void validate() {
        namesValidator.validate(names);
    }

    @Override
    public String readLine() {
        return names;
    }
}
