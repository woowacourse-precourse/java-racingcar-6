package racingcar.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CreateCar {
    private List<Car> cars = new ArrayList<>();

    public List<Car> createCar(String string_cars){
        String[] car_name = settingCar(string_cars);

        for (String s : car_name) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public String[] settingCar(String s){
    String[] car = Console.readLine().split(",");
    ValidCheck.namesize_check(car);

    return car;
    }
}