package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Race {

    public Map<String, String> saveCarMap(String carNameString) {

        Map<String, String> carMap = new HashMap<>();

        String[] carNameArray = carNameString.split(",");
        for (String carName : carNameArray) {
            carMap.put(carName, "");
        }

        return carMap;
    }

}
