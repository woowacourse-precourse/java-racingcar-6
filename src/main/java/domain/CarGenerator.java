package domain;

import java.util.HashMap;
import java.util.List;

public class CarGenerator {
    public HashMap<String, Integer> createLocationMap(List<String> carNames) {
        HashMap<String, Integer> carLocationMap = new HashMap<>();
        for (String carName : carNames) {
            carLocationMap.put(carName, 0);
        }
        return carLocationMap;
    }
}
