package racingcar.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Verification {
    public static void verifyCarName(String carName){
        verifyCarNameLen(carName);
        verifyCarNameSpace(carName);
    }

    public static void verifyTryNum(String tryNum){
        verifyIsDigitCheck(tryNum);
        verifyPositiveNum(tryNum);
    }

    private static void verifyCarNameLen(String carName) throws IllegalArgumentException{
        if (carName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름을 1글자 이상 입력해주세요.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과했습니다.");
        }
    }

    private static void verifyCarNameSpace(String carName) throws IllegalArgumentException {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 있습니다.");
        }
    }

    public static void verifyDuplication(String[] carArray) throws IllegalArgumentException{
        Set<String> set = new HashSet<>(Arrays.asList(carArray));
        if (set.size() < carArray.length){
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
    }

    private static void verifyIsDigitCheck(String tryNum){
        for(int i = 0; i < tryNum.length(); i++){
            isDigitCheck(tryNum, i);
        }
    }

    private static void isDigitCheck(String string, int index) throws IllegalArgumentException{
        if(!Character.isDigit(string.charAt(index))){
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }

    private static void verifyPositiveNum(String tryNum) throws IllegalArgumentException{
        int tryNumInt = Integer.parseInt(tryNum);
        if(tryNumInt <= 0){
            throw new IllegalArgumentException("양수를 입력해야합니다.");
        }
    }

}
