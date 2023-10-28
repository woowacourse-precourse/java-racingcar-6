package racingcar.validator;

public class RoundValidator {

    private final static String ERROR = "[ERROR]";
    private static String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";
    public static String tryCount;

    public RoundValidator(String input){
        tryCount = input;
        isNumError();
    }
    public void isNumError(){
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR+NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}