package racingcar.validator;

import java.util.regex.Pattern;

public class InputValidate {

    private static final String INCORRECT_FORMAT_MESSAGE = "잘못된 형식의 값을 입력하였습니다";

    public static void validateCarName(String[] carNames){
        String regex = "^[a-zA-Z0-9]{1,5}+$";
        for (String carName : carNames) {
            if(!Pattern.matches(regex, carName)){
                incorrectFormat();
            }
        }
    }

    public static void validateCarMoveNum(String moveNum){
        try{
            Integer.parseInt(moveNum);
        } catch (Exception e){
            incorrectFormat();
        }
    }

    public static void incorrectFormat(){
        throw new IllegalArgumentException(INCORRECT_FORMAT_MESSAGE);
    }
}
