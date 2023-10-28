package view;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

public class View {

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
}
