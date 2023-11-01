package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class nameValidator {
    public static void namesException(String names){
        isNamesNull(names);
        List<String> nameList = List.of(names.split(","));
    }
    public static void isNamesNull(String names) {
        if (names.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력해주세요");
    }
}
