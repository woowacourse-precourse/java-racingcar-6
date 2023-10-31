package racingcar.view;

import racingcar.validator.NamesInputValidator;
import racingcar.validator.Validator;

public class NamesInput implements Input {

    private static final String ASK_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)  ";

    private final Validator namesValidator = new NamesInputValidator();
    private final String names;

    public NamesInput() {
        Output.printMessage(ASK_NAME_OF_CARS);
        names = ConsoleInput.readLine();
        validate();
    }

    private void validate() {
        namesValidator.validate(names);
    }

    public String readLine() {
        return names;
    }
}
