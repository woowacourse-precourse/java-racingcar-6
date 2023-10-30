package racingcar.domain;

import java.util.List;

public class Utils {
    // string 배열을 list로 변경
    public static List<String> translateArrayToList(String[] stringArray, List<String> stringList) {
        for (String stringVariable : stringArray) {
            stringList.add(stringVariable.trim());
        }

        return stringList;
    }

    // 이름 조건에 대한 예외 처리
    public static boolean checkNameOverLengthException(String[] carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                return true;
            }
        }
        return false;
    }
}
