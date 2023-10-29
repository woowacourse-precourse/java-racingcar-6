package racingcar.view;

public class InputViewValidator {

    private static final InputViewValidator inputViewValidator = new InputViewValidator();

    private InputViewValidator() {};

    public static InputViewValidator getInstance(){
        return inputViewValidator;
    }

    public boolean validateCarNames(String carNames){

        if(isCarNameEmpty(carNames)){
            throw new IllegalArgumentException("[ERROR] : 차 이름이 빈 값일 수 없습니다");
        }
    }

    public boolean isCarNameEmpty(String carNames) {
        return carNames.equals("");
    }

}
