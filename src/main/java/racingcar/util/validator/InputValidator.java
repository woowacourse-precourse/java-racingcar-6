package racingcar.util.validator;

import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void isStringBlank(String str) {
        if(str == null || str.isBlank()){
            throw new IllegalArgumentException("입력받은 값이 없음");
        }
    }
    public static void checkComma(String str) {
        if(str.charAt(0) ==',' || str.charAt(str.length()-1) ==','){
            throw new IllegalArgumentException("입력받은 값 앞뒤 ','쉼표 포함");
        }
    }
    public static void checkBlank(String str) {
        if(str.charAt(0) ==' ' || str.charAt(str.length()-1) ==' '){
            throw new IllegalArgumentException("문자열 앞뒤 ' '공백 포함");
        }
    }

    public static void IsStringLengthValid(String str)
    {
        if(str.length() > 5){
            throw new IllegalArgumentException("문자열 길이 6자리 이상");
        }
        if(str.length() == 0)
        {
            throw new IllegalArgumentException("문자열 길이 0");
        }
    }

    public static void IsListDuplicate(List<String> list)
    {
        Set<String> set = Set.copyOf(list);
        if(list.size() != set.size()) {
            throw new IllegalArgumentException("문자열 중복");
        }
    }

}
