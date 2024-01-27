package game;

import java.util.HashMap;
import java.util.Map;

public class BeforeGame {

    //  차 이름 입력받기
    public static Map<String, Integer> enterTheCarsName(String carsName) {

        String[] cars = carsName.split(",");

        Map<String, Integer> carsMap = new HashMap<>();

        for(String car : cars) {
            car = checkCarNameFormat(car);
            carsMap.put(car, 0);
        }

        return carsMap;
    }

    private static String checkCarNameFormat(String car) {
        car = car.trim();
        if (car.length() > 5 || car.isEmpty())
            throw new IllegalArgumentException();

        return car;
    }



}
