package racingcar.util;

public class Validator {
    public static void lengthvalidator (String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("글자 수를 초과하셨습니다.");
        }



    }

}
