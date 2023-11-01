package racingcar.view;

public class ExceptionHandler {
    public static final String ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 5글자 이하입니다.";
    public static final String ERROR_INTEGER_ONLY = "정수만 입력 가능합니다.";

    public boolean isValidCarName(String carName){
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG);
        }
        return true;
    }

    public boolean isIntegerInput(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_INTEGER_ONLY);
        }
        return true;
    }
}
