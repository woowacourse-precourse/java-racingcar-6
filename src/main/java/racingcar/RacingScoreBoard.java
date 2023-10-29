package racingcar;

import java.util.HashMap;
import java.util.Map;

public class RacingScoreBoard {
    private final Map<String, Integer> scores;

    //자동차 입력을 받고 이동 횟수는 0으로 초기화 된 HashMap을 만든다.
    //HashMap(이름, 이동 횟수)
    public RacingScoreBoard(String inputNames) {
        scores = new HashMap<>();
        String[] names = inputNames.split(",");
        for (String name : names) {
            scores.put(name.trim(), 0);
        }
    }
}
