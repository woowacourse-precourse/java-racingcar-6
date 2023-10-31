package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    public boolean isForward() {
        RandomNumber randomNumber = new RandomNumber();
        int number = randomNumber.createRandom();
        if (number >= 4) {
            return true;
        }
        return false;
    }

    public Map<String, Integer> racing(List<String> carNames, int moveCount) {

        Race T = new Race();
        Map<String, Integer> raceResult = new HashMap<String, Integer>();
        return raceResult;
    }
}
