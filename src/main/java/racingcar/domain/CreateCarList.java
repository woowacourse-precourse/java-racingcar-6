package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CreateCarList {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> createCar_list(String string_cars){
        String[] car_name = splitCarsName(string_cars);

        for (String s : car_name) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public String[] splitCarsName(String cars){
    String[] car = cars.split(",");
    ValidCheck.namesize_check(car);

    return car;
    }
}