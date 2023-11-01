package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    // 자동차 이름을 쉼표로 구분된 목록으로 파싱
    public List<String> parseCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));

    }

    // 시도 횟수를 정수로 파싱
    public int parseNumberOfTrials(String input) {
        return Integer.parseInt(input);
    }
}
