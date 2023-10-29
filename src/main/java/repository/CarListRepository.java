package repository;

import java.util.HashMap;

public class CarListRepository {
    public HashMap<String, Integer> carList = new HashMap<>();

    public void setCarListRepository(String carList) {
        String[] carName = carList.split(",");
        for (String car : carName) {
            this.carList.put(car, 0);
        }
    }

    public void forwardCar(String carName) {
        int originalValue = this.carList.get(carName);
        this.carList.put(carName, originalValue + 1);
    }
}
