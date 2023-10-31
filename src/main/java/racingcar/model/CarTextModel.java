package racingcar.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CarTextModel {

    public HashMap<String, String> parseCarNames(String carNames) {

        List<String> carNameList = Arrays.asList(carNames.split(","));
        HashMap<String, String> carHashMap = new HashMap<>();


        for(int i=0; i<carNameList.size(); i++) {
            carHashMap.put(carNameList.get(i), "");
        }


        return carHashMap;
    }

}
