package racingcar.model;

import java.util.HashMap;

public class Car {
    private static final String ONE_STEP  = "-";
    private static HashMap<String,String> hashMap;

    public Car(HashMap<String,String> hashMap) {
        this.hashMap = hashMap;
    }

    public static HashMap<String,String> getHashMap() {
        return hashMap;
    }

    public static void move(String carName, int randomNumber) {
        if (randomNumber >= 4) {
            hashMap.put(carName, hashMap.get(carName) + "-");
        }
    }

}
