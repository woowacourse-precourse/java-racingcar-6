package racingcar.core.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamesParser {
    public List<String> parsing(String stringNames){
        if (stringNames.startsWith(" ") || stringNames.startsWith(",")) { // 시작이 이상한 경우
            throw new IllegalArgumentException();
        }
        if (stringNames.endsWith(",") || stringNames.endsWith(", ")) {// 끝이 이상한 경우
            throw new IllegalArgumentException();
        }
        if (stringNames.contains(",,") || stringNames.contains(", ,")) { // 쉼표가 이상한 경우
            throw new IllegalArgumentException();
        }
        return Arrays.asList(stringNames.split(","));
    }
}
