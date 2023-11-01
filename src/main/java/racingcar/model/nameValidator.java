package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nameValidator {
    public static List<String> namesException(String names){
        isNamesNull(names);
        List<String> nameList = List.of(names.split(","));
        isNamesRightSize(nameList);
        isNamesUnique(nameList);
        return nameList;
    }
    public static void isNamesNull(String names) {
        if (names.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        if (names.endsWith(",")) throw new IllegalArgumentException("쉼표로 끝내면 안됩니다");
    }

    public static void isNamesRightSize(List<String> nameList) {
        for (String name : nameList) {
            if (name.length()>5) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            if (name.isEmpty()) throw new IllegalArgumentException("쉼표를 올바르게 사용해주세요");
        }
    }
    public static void isNamesUnique(List<String> nameList) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : nameList) {
            if (!uniqueNames.add(name)) throw new IllegalArgumentException("중복된 이름을 사용하면 안됩니다");
        }

    }
}
