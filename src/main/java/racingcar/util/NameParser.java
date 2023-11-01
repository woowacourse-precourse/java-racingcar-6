package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class NameParser {
    private final static String STRING_SEPARATION_EXCEPTION_MESSAGE = "(,)쉼표로 이름을 구분해주세요";
    List<String> nameList = new ArrayList<>();

    public List<String> parseName(String nameString) {
        if (!nameString.contains(",")) {
            throw new IllegalArgumentException(STRING_SEPARATION_EXCEPTION_MESSAGE);
        }

        for (String name : nameString.split(",")) {
            nameList.add(name);
        }
        return nameList;
    }
}
