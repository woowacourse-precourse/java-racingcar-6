package racingcar;

import java.util.HashMap;

public class Computer {
    Validation validation = new Validation();
    public HashMap<String, Integer> splitCarName(String carNameString){
        HashMap<String, Integer> carMap = new HashMap<>();

        String[] temp = carNameString.split(",");

        for(int i = 0 ; i < temp.length; i++){
            validation.carNameValidation(temp[i]);
            carMap.put(temp[i],0);
        }

        return carMap;
    }

}
