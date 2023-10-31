package racingcar.common.type;

import java.util.Arrays;
import java.util.List;

public class Names {
    private final List<String> nameList;

    public static Names of(String[] names) {
        var list = Arrays.asList(names);
        return new Names(list);
    }

    private Names(List<String> nameList) {
        validateIsPobi(nameList);
        this.nameList = List.copyOf(nameList);
    }

    public List<String> getNameList() {
        return nameList;
    }

    private void validateIsPobi(List<String> nameList) {
        if (nameList.contains("pobi") && nameList.contains("javaji")) {
            throw new IllegalArgumentException("pobi와 javaji는 동일 인물입니다.");
        }
    }
}
