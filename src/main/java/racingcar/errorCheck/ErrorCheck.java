package racingcar.errorCheck;

import java.util.HashSet;
import java.util.Set;

public class ErrorCheck {
    public static void isCarNameFive(String[] carList) {
        for (int i = 0; i < carList.length; i++) {
            if (carList[i].length() > 5) {
                throw new IllegalArgumentException("차 이름 길이가 5이하가 아닙니다");
            }
        }
    }

    public static void isDuplicationNameCar(String[] carList) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < carList.length; i++) {
            set.add(carList[i]);
        }
        if (set.size() != carList.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다");
        }
    }

    public static void isZeroValues(int cnt) {
        if (cnt < 1) {
            throw new IllegalArgumentException("잘못된 입력입니다 1이상의 값을 입력해주세요");
        }

    }

    public static void isTryDigit(String cnt) {
        char[] charCnt = cnt.toCharArray();
        for (char c : charCnt) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("잘못된 입력입니다 정수를 입력해주세요");
            }
        }
    }

    public static void isCarsNameInSpace(String[] carList) {
        for (String car : carList) {
            if (car.contains(" ")) {
                throw new IllegalArgumentException("잘못된 입력입니다 공백없이 입력해주세요");
            }
        }
    }
}

