package view;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

public class InputView {

    private static InputView instance;

    private final Validator validator;
    private static String inputString;

    private InputView() {
        validator = new Validator();
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    private void getString() {
        inputString = Console.readLine();
    }

    public String requestCarsName() {
        getString();
        validator.getCarsNameValidationChk(inputString);
        return inputString;
    }

    public int requestPlayTime() {
        getString();
        validator.getPlayTimeValidationChk(inputString);
        return Integer.parseInt(inputString);
    }
}
