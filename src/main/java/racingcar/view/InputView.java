package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constants.Message;
import racingcar.util.Validator;

public class InputView {
    private final Validator validator;
    private final String SEPARATOR_REGEX = ",";

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
        return Arrays.stream(getInput().split(SEPARATOR_REGEX))
                .filter(validator::validateLengthOfName)
                .toList();
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
