package racingcar.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CreateCarList {
    private final HashMap<String,Integer> cars = new LinkedHashMap<>();

    public HashMap<String,Integer> createCar_list(String string_cars){
        String[] car_name = splitCarsName(string_cars);

        for (String s : car_name) {
            cars.put(s,0);
        }

        return cars;
    }

    public String[] splitCarsName(String cars){
    String[] car = cars.split(",");
    ValidCheck.namesize_check(car);

    return car;
    }
}