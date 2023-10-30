package racingcar.model;

import java.util.HashMap;
import java.util.Map;

import static racingcar.util.Constants.CAR_NAME_MAX_LENGTH;
import static racingcar.util.Constants.SPLIT;
import static racingcar.util.Constants.INIT;
import static racingcar.util.VerificationMessage.OVER_SIZE;

public class Car {
    private final Map<String,Integer> carMap;
    public Car(String cars) {
        this.carMap = createCar(cars);
    }
    public Map<String,Integer> createCar(String cars) {
        String[] carArr = cars.split(SPLIT);
        Map<String,Integer> carMap = new HashMap<>();
        for (String car : carArr) {
            if(!checkNameLength(car)) throw new IllegalArgumentException(OVER_SIZE);
            carMap.put(car,INIT);
        }
        return carMap;
    }
    private boolean checkNameLength(String car){
        return car.length() <= CAR_NAME_MAX_LENGTH;
    }
    public Map<String,Integer> getCarMap() {
        return this.carMap;
    }
}
