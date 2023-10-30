package racingcar.model;

import java.util.*;
import java.util.stream.Stream;

public class Cars {
    private List<String> carNames;
    private Map<String, Integer> carScores;


    public Cars(List<String> carNames) {
        carScores = new HashMap<String, Integer>();
        this.carNames = carNames;
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

    public void increaseCarScore(String carName) {
        int score = carScores.get(carName) + 1;
        carScores.put(carName, score);
    }


}
