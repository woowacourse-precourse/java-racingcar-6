package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainerSetting {

    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Map<String, Integer> initMap(List<String> userInput){
        Map<String, Integer> numMoveMap = new HashMap();
        for (String carType: userInput){
            if (!numMoveMap.containsKey(carType)){
                numMoveMap.put(carType, 0);
            }
        }
        return numMoveMap;
    }

    public Map<String, Integer> decideIncMove(List<String> userInput, Map<String, Integer>numMoveMap) {
        for (String carType : userInput) {
            if (randomNumberGenerator.generateRandomNumber() < 4) {
                continue;
            }
            numMoveMap.put(carType, numMoveMap.get(carType) + 1);
        }
        return numMoveMap;
    }

}
