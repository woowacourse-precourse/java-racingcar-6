package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String WRONG_LENGTH_INPUT_MESSAGE = "이름 길이를 5자 이하로 해주시길 바랍니다";

    public List<String> toValidateData(String memberString) {
        String str = memberString.replace(" ", ""); // 입력 받은 문자열 중 공백 제거
        List<String> list = Arrays.asList(str.split(",")); // 입력받은 문자열 ,단위로 나눠서 list에 넣음

        if (!isOverLength(list)) {
            throw new IllegalArgumentException();
        }
        return list;
    }
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public String toValidateTryNum(String tryNum){
        if(!isNumeric(tryNum)){
            throw new IllegalArgumentException();
        }
        return tryNum;
    }
    public boolean isOverLength(List<String> inputList) {
        if(inputList.get(0) == ""){
            return false;
        }
        for (String carName : inputList) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
