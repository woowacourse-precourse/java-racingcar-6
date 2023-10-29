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
        List<String> printResultList = getRoad(numMoveMap);
        for (String gameResult: printResultList){
            System.out.println(gameResult);
        }
        System.out.println("");
        return numMoveMap;
    }
    public List<String> getRoad(Map<String, Integer> numMap){
        List<String> printList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: numMap.entrySet()){
            String car = entry.getKey();
            int key = entry.getValue();
            printList.add(car + ":" + "-".repeat(key));
        }
        return printList;
    }

}
