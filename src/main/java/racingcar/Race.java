package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Race {
    Map<String, String> scorePerCar = new HashMap<>();
    
    public void initScorePerCar(String[] carArray) {
        for (String car : carArray) {
            scorePerCar.put(car, "");
        }
    }
    
}
