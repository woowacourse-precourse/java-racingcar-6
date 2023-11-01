package racingcar.util;

import java.util.regex.Pattern;

public class StringConverter {

    public static int toInteger(String data){
        if(!Pattern.matches("\\d+",data)){
            throw new IllegalArgumentException("입력한 수는 정수가 아닙니다.");
        }

        return Integer.parseInt(data);
    }

}
