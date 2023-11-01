package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class GameService {
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void forwardOrStopAccordingToNumber(int number, String name, Map<String, Integer> distance) {
        if (number >= 4) {
            distance.put(name, distance.get(name) + 1);
        }
    }
}
