package racingcar.domain;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.util.Parser.parseCarNames;

public class Cars {
    private final List<String> carNames;
    private final Map<String, Integer> carScores;


    public Cars(String carNames) {
        carScores = new HashMap<>();
        this.carNames = parseCarNames(carNames);
        this.carNames.forEach(carName -> carScores.put(carName, 0));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Map<String, Integer> getCarScores() {
        return carScores;
    }

    public int getBestScore(){
        return Collections.max(carScores.values());
    }

    public void moveForward(String carName) {
        int score = carScores.get(carName) + 1;
        carScores.put(carName, score);
    }


}
