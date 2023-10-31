package racingcar.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameModel {
    List<String> carNames;
    int turns;
    Map<String, List<Integer>> gameState = new HashMap<>();     // 회차 무작위값 기록
    Map<String, List<Integer>> forwardState = new HashMap<>();  // 회차 자동차 위치 기록

    public RacingGameModel(List<String> carNames, int turns) {
        this.carNames = carNames;
        this.turns = turns;
        this.gameState = new HashMap<>();
        this.forwardState = new HashMap<>();
    }
}
