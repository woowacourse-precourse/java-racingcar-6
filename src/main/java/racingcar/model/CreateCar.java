package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CreateCar {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> createCar(String string_cars){
        String[] car_name = settingCar(string_cars);

        for (String s : car_name) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public String[] settingCar(String cars){
    String[] car = cars.split(",");
    ValidCheck.namesize_check(car);

    return car;
    }
}