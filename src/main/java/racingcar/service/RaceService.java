package racingcar.service;

import static racingcar.constants.RaceRule.MOVE_MAX_RANGE;
import static racingcar.constants.RaceRule.MOVE_MIN_RANGE;
import static racingcar.constants.RaceRule.MOVE_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        int maxValue = getMaxValue();

        return progressMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Entry::getKey)
                .toList();
    }

    private int getMaxValue() {
        return progressMap.entrySet().stream()
                .map(Entry::getValue)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private boolean canMoveForward() {
        int random = Randoms.pickNumberInRange(MOVE_MIN_RANGE.getValue(), MOVE_MAX_RANGE.getValue());
        return random >= MOVE_THRESHOLD.getValue();
    }

    private List<Progress> getProgressList() {
        List<Progress> progressList = new ArrayList<>();

        for (String carName : progressMap.keySet()) {
            progressList.add(new Progress(carName, progressMap.get(carName)));
        }
        return progressList;
    }
}
