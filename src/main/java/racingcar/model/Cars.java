package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Car> cars = new ArrayList<>();

    public static List<Car> generateCar(List<String> validatedCarNameList) {
        for (String nowCar : validatedCarNameList) {
            Car car = new Car(0, nowCar);
            cars.add(car);
        }
        return cars;
    }
}
