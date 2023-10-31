package racingcar.view;

import static racingcar.constants.Message.SEPARATOR_REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constants.Message;
import racingcar.util.Validator;

public class InputView {
    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public void printAskName() {
        System.out.println(Message.ASK_CAR_NAME);
    }

    public void printAskCount() {
        System.out.println(Message.ASK_TRY_COUNT);
    }

    public List<String> getCarNames() {
        String input = getInput();
        validator.validateCarName(input);
        return List.of(input.split(SEPARATOR_REGEX.toString()));
    }

    public int getTryCount() {
        return convertStrToInt(getInput());
    }


    private String getInput() {
        return Console.readLine();
    }

    private int convertStrToInt(String input) {
        validator.checkIsNumeric(input);
        return Integer.parseInt(input);
    }
}
