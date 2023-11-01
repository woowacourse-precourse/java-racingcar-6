package racingcar.util;

import java.util.List;
import java.util.Arrays;

public class Parser {
    private static final int CAR_NAME_LENGTH_MAX = 5;
    private static final String SPACE = " ";

    public int changeStringToInteger(String str) throws IllegalArgumentException{
        checkEmptyException(str);
        checkNumberZeroException(str);
        checkNumberException(str);
        return Integer.parseInt(str);
    }
    public List<String> getSplitString(String str) {
        String[] splitStrings = str.split(",");
        return checkNamingCondition(Arrays.asList(splitStrings));
    }

    private List<String> checkNamingCondition(List<String> carNames) {
        for (String carName : carNames) {
            checkEmptyException(carName);
            checkNamingException(carName);
            checkSpaceException(carName);
        }
        return carNames;
    }
    private void checkEmptyException(String str) throws IllegalArgumentException{
        if (str.isEmpty()) {
            throw new IllegalArgumentException("빈값은 라운드가 시작되지 않습니다.");
        }
    }
    private void checkNumberZeroException(String str) throws IllegalArgumentException{
        if (str.equals("0")) {
            throw new IllegalArgumentException("0값은 라운드가 시작되지 않습니다.");
        }
    }
    private void checkNumberException(String str) throws IllegalArgumentException{
        try{
            Integer.parseInt(str);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }
    private void checkNamingException(String str) throws IllegalArgumentException{
        if (str.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("1~5글자의 자동차 이름을 입력하세요.");
        }
    }
    private void checkSpaceException(String str) throws IllegalArgumentException{
        if(str.contains(SPACE)){
            throw new IllegalArgumentException("공백없이 입력하세요.");
        }
    }
}
