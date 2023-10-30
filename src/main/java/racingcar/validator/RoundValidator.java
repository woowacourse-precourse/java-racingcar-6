package racingcar.validator;

public class RoundValidator {

    private final static String ERROR = "[ERROR]";
    private final static String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";
    public static String repeatNum;

    public RoundValidator(String input){
        repeatNum = input;
        isNumError();
    }
    public void isNumError(){
        try {
            Integer.parseInt(repeatNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR+NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}