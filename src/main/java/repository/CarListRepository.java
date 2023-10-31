package repository;

import java.util.LinkedHashMap;

public record CarListRepository(LinkedHashMap<String, Integer> carList) {

    public void forwardCar(String carName) {
        Integer currentValue = carList.get(carName);
        carList.put(carName, currentValue + 1);
    }
}
