package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {

    private final Map<String, Integer> raceResult = new HashMap<>();

    public ScoreBoard() {
    }

    public Map<String, Integer> write(List<Car> cars) {
        // Map에 자동차 정보 입력 (이름, 이동 거리)
        for (Car car : cars) {
            raceResult.put(car.getName(), car.getPosition());
        }

        return raceResult;
    }
}
