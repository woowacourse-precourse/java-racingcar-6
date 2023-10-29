package view;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

public class InputView {

    private final Validator validator = new Validator();
    private static String inputString;

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
