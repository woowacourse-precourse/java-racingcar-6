package racingcar.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Verification {
    public static void verifyCarName(String carName){
        verifyCarNameLen(carName);
        verifyCarNameSpace(carName);
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
}
