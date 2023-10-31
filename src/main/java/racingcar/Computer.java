package racingcar;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    Validation validation = new Validation();
    public ConcurrentHashMap<String, Integer> splitCarName(String carNameString) {
        ConcurrentHashMap<String, Integer> carMap = new ConcurrentHashMap<>();

        String[] temp = carNameString.split(",");

        for (int i = 0; i < temp.length; i++) {
            validation.carNameValidation(temp[i]);
            carMap.put(temp[i],0);
        }

        return carMap;
    }

    int makeRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }
    int decideToMoveForward(int randomNum){
        if(randomNum >= 4){
            return 1;
        }
        return 0;
    }

    ConcurrentHashMap<String, Integer> executeRound(ConcurrentHashMap<String, Integer> carMap){

        for(Map.Entry<String, Integer> entry : carMap.entrySet()){
            String name = entry.getKey();
            int distance = entry.getValue()+decideToMoveForward(makeRandomNum());
            carMap.put(name, distance);
        }

        return carMap;
    }


}
