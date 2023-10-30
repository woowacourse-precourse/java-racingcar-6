package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

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

    // String형에서 int형으로 변환하는 것에 대한 예외 처리
    public static boolean checkStringToIntException(String stringSentence) {
        for (int i = 0; i < stringSentence.length(); i++) {
            if (!Character.isDigit(stringSentence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static int makeRandomInt() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
