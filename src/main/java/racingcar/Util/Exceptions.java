package racingcar.Util;

import static racingcar.Util.Constants.MAX_LENGTH_NAME;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exceptions {
    public static void isDuplicated(List<String> nameList) {
        Set<String> nameSet = new HashSet<String>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException("중복된 이름을 사용하였습니다.");
        }
    }

    public static void isBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름을 제대로 작성해주세요.");
        }
    }

    public static void isLessThanMaxLength(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("최대 길이 보다 긴 이름을 입력했습니다.");
        }
    }

    public static void isPositiveNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("입력한 숫자가 잘못 됐습니다.");
        }
    }
}
