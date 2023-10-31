package racingcar.domain;

import java.util.Map;

public class Racing {

    NumberGenerator numberGenerator = new NumberGenerator();

    public Boolean isMoveCondition() {
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= 4;
    }

    public Map<String, String> moveResult(Map<String, String> raceScore) {
        for (String key : raceScore.keySet()) {
            if (isMoveCondition()) {
                String value = raceScore.get(key) + "-";
                raceScore.put(key, value);
            }
            System.out.println(key + " : " + raceScore.get(key));
        }
        return raceScore;
    }

}
