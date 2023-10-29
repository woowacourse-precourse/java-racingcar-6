package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateMoveMap {
    UserInput carInput = new UserInput();
    CreateRandomNumber createRandomNumber = new CreateRandomNumber();

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
            if (createRandomNumber.generateRandomNumber() < 4) {
                continue;
            }
            numMoveMap.put(carType, numMoveMap.get(carType) + 1);
        }
        return numMoveMap;
    }
}
