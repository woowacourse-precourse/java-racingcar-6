package racingcar;

import java.util.HashMap;

public class Computer {
    public HashMap<String, Integer> splitCarName(String carNameString){
        HashMap<String, Integer> carMap = new HashMap<>();

        String[] temp = carNameString.split(",");

        for(int i = 0 ; i < temp.length; i++){
            carMap.put(temp[i],0);
        }

        return carMap;
    }

}
