package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveMoveLog {
    UserInput carInput = new UserInput();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Map<String, Integer> initMap(List<String> carInput){
        Map<String, Integer> numMoveMap = new HashMap();
        for (String carType: carInput){
            if (!numMoveMap.containsKey(carType)){
                numMoveMap.put(carType, 0);
            }
        }
        return numMoveMap;
    }

    public Map<String, Integer> decideIncMove(List<String> carInput, Map<String, Integer>numMoveMap) {
        for (String carType : carInput) {
            if (randomNumberGenerator.generateRandomNumber() < 4) {
                continue;
            }
            numMoveMap.put(carType, numMoveMap.get(carType) + 1);
        }
        return numMoveMap;
    }
    public void printMoveResult(Map<String, Integer> numMoveMap) {
        for (Map.Entry<String, Integer> entrySet : numMoveMap.entrySet()) {
            System.out.println(entrySet.getKey() + ":" + "-".repeat(entrySet.getValue()));
        }
        System.out.println();
    }

}
