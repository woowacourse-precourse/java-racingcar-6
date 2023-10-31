package repository;

import java.util.Map;

public class CarListRepository {
    private final Map<String, Integer> carList;

    public CarListRepository(Map<String, Integer> carList) {
        this.carList = carList;
    }

    public void forwardCar(String carName) {
        Integer currentValue = carList.get(carName);
        carList.put(carName, currentValue + 1);
    }

    public Map<String, Integer> getCarList() {
        return carList;
    }
}
