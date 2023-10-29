package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.dto.Progress;

public class RaceService {
    private HashMap<String, Integer> progressMap; // TODO: 따로 객체로 분리하는 것이 나을 듯

    public RaceService() {
        progressMap = new HashMap<>();
    }

    public void init(List<String> carNames) {
        for (String carName : carNames) {
            progressMap.put(carName, 0);
        }
    }

    public List<Progress> moveCar() {
        for (String carName : progressMap.keySet()) {
            if (canMoveForward()) {
                Integer curDistance = progressMap.get(carName);
                progressMap.replace(carName, curDistance + 1);
            }
        }
        return getProgressList();
    }

    public List<String> getWinner() {
        int maxValue = progressMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .max(Integer::compareTo)
                .orElse(0);

        return progressMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Entry::getKey)
                .toList();
    }

    private boolean canMoveForward() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    private List<Progress> getProgressList() {
        List<Progress> progressList = new ArrayList<>();

        for (String carName : progressMap.keySet()) {
            progressList.add(new Progress(carName, progressMap.get(carName)));
        }
        return progressList;
    }
}
