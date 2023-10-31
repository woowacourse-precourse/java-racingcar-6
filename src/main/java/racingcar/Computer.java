package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    static final int MIN_RANGE = 0;
    static final int MAX_RANGE = 9;
    Validation validation = new Validation();
    public ConcurrentHashMap<String, Integer> splitCarName(String carNameString) {
        ConcurrentHashMap<String, Integer> carMap = new ConcurrentHashMap<>();

        String[] temp = carNameString.split(",");

        for (int i = 0; i < temp.length; i++) {
            String name = removeBlank(temp[i]);
            validation.carNameValidation(name);
            carMap.put(name,0);
        }

        return carMap;
    }

    String removeBlank(String name){
        return name.replaceAll(" ", "");
    }

    int getIntRound(String roundString){
        validation.roundTypeValidation(roundString);
        validation.roundValueValidation(Integer.parseInt(roundString));
        return Integer.parseInt(roundString);
    }

    int makeRandomNum(){
        return Randoms.pickNumberInRange(MIN_RANGE,MAX_RANGE);
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

    ArrayList<String> findWinner(ConcurrentHashMap<String, Integer> carMap){
        ArrayList<String> winner = new ArrayList<>();

        Integer maxValue = Collections.max(carMap.values());

        for(Map.Entry<String, Integer> entry : carMap.entrySet()){
            if(entry.getValue() == maxValue){
                winner.add(entry.getKey());
            }
        }

        return winner;
    }

}
