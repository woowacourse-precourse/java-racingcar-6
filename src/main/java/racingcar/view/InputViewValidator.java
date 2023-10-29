package racingcar.view;

public class InputViewValidator {

    private static final InputViewValidator inputViewValidator = new InputViewValidator();

    private InputViewValidator() {};

    public static InputViewValidator getInstance(){
        return inputViewValidator;
    }

}
