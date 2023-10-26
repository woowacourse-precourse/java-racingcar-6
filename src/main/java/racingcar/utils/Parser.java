package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    /**
     * 각 자동차 명 사이에 쉼표와 공백을 기준으로 파싱
     */
    public static List<String> parseCarsName(String input) {
        return new ArrayList<>(List.of(input.split(",\\s*")));
    }
}
