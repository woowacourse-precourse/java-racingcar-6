package racingcar.validator;

public class RoundValidator {

    private static String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";
    public static String tryCount;

    public RoundValidator(String input){
        this.tryCount = input;
        isNumError();
    }
    public void isNumError(){
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
