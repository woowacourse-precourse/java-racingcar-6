package racingcar.common.type;

import java.util.Arrays;
import java.util.List;

public class Names {
    private final List<String> nameList;

    public Names(String[] names) {
        this.nameList = Arrays.asList(names);
        validateisPobi();
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void validateisPobi() {
        if (nameList.contains("pobi") && nameList.contains("javaji")) {
            throw new IllegalArgumentException("pobi와 javaji는 동일 인물입니다.");
        }
    }
}
