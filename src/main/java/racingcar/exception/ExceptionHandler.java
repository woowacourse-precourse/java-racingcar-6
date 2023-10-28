package racingcar.exception;

import racingcar.constants.ExceptionConstants;
import racingcar.constants.GameConstants;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandler {
    //단일 이름에 대해서
    public static void shortNameLengthException(String name){
        if(name.length() < 1){
            throw new IllegalArgumentException(ExceptionConstants.INVALID_NAME_SHORT);
        }
    }
    public static void LongNameLengthException(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException(ExceptionConstants.INVALID_NAME_LONG);
        }
    }
    public static void blankNameException(String name){
        if(name.isBlank()){
            throw  new IllegalArgumentException(ExceptionConstants.INVALID_NAME_BLANK);
        }
    }

    //다중 이름에 대해서
//    public static void noCommaException(String names){
//        if(!names.contains(",")){
//            throw new IllegalArgumentException(ExceptionConstants.NO_COMMA_EXCEPTION);
//        }
//    }
    public static void blankNamesException(String names){
        if(names.isBlank()){
            throw new IllegalArgumentException(ExceptionConstants.INVALID_NAME_ZERO);
        }
    }
    public static void duplicateNameException(String names){
        List<String> namesList = new ArrayList<>();
        namesList.addAll(List.of(names.split(",")));
        if(namesList.stream().distinct().count() < namesList.size()){
            throw new IllegalArgumentException(ExceptionConstants.DUPLICATE_NAME);
        }
    }
    public static void tooManyNamesException(String names){
        List<String> namesList = new ArrayList<>();
        namesList.addAll(List.of(names.split(",")));
        if(namesList.size() > GameConstants.MAX_NAME_COUNT){
            throw new IllegalArgumentException(ExceptionConstants.EXCEED_NAME_COUNT);
        }
    }

    // 순서대로 사용 필수
    public static void notDigitException(String number){
        if(!number.matches("\\d+")) {
            throw new IllegalArgumentException(ExceptionConstants.INVALID_DIGIT_INPUT);
        }
    }
    public static void tooBigDigitException(String number){
        try{
            if(GameConstants.MAX_TRY_NUM < Integer.parseInt(number)){
                throw new IllegalArgumentException(ExceptionConstants.EXCEED_DIGIT_INPUT);
            }
        }catch(Exception e){
            throw new IllegalArgumentException(ExceptionConstants.EXCEED_DIGIT_INPUT);
        }
    }
    public static void zeroOrMinusTryNumberException(String number){
        if(Integer.parseInt(number) <= 0){
            throw new IllegalArgumentException(ExceptionConstants.INVALID_ZERO_DIGIT);
        }
    }

}
