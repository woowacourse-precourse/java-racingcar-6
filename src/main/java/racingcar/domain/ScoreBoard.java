package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {

    private final Map<String, Integer> raceResult = new HashMap<>();

    public ScoreBoard() {
    }

    public void write(List<Car> cars) {
        // Map에 자동차 정보 입력 (이름, 이동 거리)
        for (Car car : cars) {
            raceResult.put(car.getName(), car.getScore());
        }
    }

    public List<String> findWinners() {
        int maxValue = Collections.max(raceResult.values());
        // Map 데이터 중 value가 max인 key값 반환
        return raceResult.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .toList();
    }
}
