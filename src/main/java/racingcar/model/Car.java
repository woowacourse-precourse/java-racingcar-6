package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.util.Constants.CAR_NAME_MAX_LENGTH;
import static racingcar.util.Constants.SPLIT;
import static racingcar.util.Constants.INIT;
import static racingcar.util.VerificationMessage.OVER_SIZE;
import static racingcar.util.VerificationMessage.DUPLICATE_NAME;

public class Car {
    private final Map<String,Integer> carMap;
    private final List<String> carList = new ArrayList<>();
    public Car(String cars) {
        this.carMap = createCar(cars);
    }
    public Map<String,Integer> createCar(String cars) {
        String[] carArr = cars.split(SPLIT);
        Map<String,Integer> carMap = new HashMap<>();
        for (String car : carArr) {
            if(!checkNameLength(car)) throw new IllegalArgumentException(OVER_SIZE);
            if(duplicateName(car,carMap)) throw new IllegalArgumentException(DUPLICATE_NAME);
            carMap.put(car,INIT);
            carList.add(car);
        }
        return carMap;
    }
    private boolean checkNameLength(String car){
        return car.length() <= CAR_NAME_MAX_LENGTH;
    }
    private boolean duplicateName(String car, Map<String,Integer> carMap) {
        return carMap.containsKey(car);
    }
    public Map<String,Integer> getCarMap() {
        return this.carMap;
    }
    public List<String> getCarList() {
        return this.carList;
    }
}
