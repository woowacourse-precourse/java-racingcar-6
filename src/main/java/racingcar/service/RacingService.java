package racingcar.service;

import java.util.HashMap;

public class RacingService {
    public static HashMap<String, String> enterCarName(String args) {
        HashMap<String, String> cars = new HashMap<>();
        String[] arr = args.split(",");
        for (String carName : arr) {
            cars.put(carName, "");
        }
        return cars;
    }
}
