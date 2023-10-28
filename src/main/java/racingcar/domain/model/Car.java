package racingcar.domain.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Car {
    public HashMap<String, Integer> carList = new LinkedHashMap<>();

    public void addCar(String carNames) {
        carList = Arrays.stream(carNames.split(","))
                .collect(Collectors.toMap(
                        key -> key,
                        value -> 0,
                        (version1, version2) -> version1,
                        LinkedHashMap::new
                ));
    }

    public void updateCar(String carName) {
        if (carList.containsKey(carName)) {
            carList.put(carName, carList.get(carName) + 1);
        }
    }
}
