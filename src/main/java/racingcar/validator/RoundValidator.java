package racingcar.validator;

public class RoundValidator {

    private final static String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";
    private final static String NUMBER_WILL_MORE_THAN_ONE = "1이상의 라운드를 숫자로 입력해주세요";
    public static String repeatNum;

    public RoundValidator(String input){
        repeatNum = input;
        isNumError();
        isNumMoreThanOne();
    }

    public void isNumError(){
        try {
            Integer.parseInt(repeatNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void isNumMoreThanOne(){
        if(Integer.parseInt(repeatNum) < 1){
            throw new IllegalArgumentException(NUMBER_WILL_MORE_THAN_ONE);
        }
    }
}