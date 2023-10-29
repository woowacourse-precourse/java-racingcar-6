package racingcar.service;

import java.util.HashMap;
import java.util.List;

public class RaceService {
    private HashMap<String, Integer> progressMap; // TODO: 따로 객체로 분리하는게 나을 것 같기도

    public RaceService() {
        progressMap = new HashMap<>();
    }

    public void init(List<String> carNames) {
        for (String carName : carNames) {
            progressMap.put(carName, 0);
        }
    }
}
