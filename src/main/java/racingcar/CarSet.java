package racingcar;

import java.util.ArrayList;

public class CarSet {

    public static ArrayList<Car> setCar(String carNames) {
        ArrayList<Car> cars = new ArrayList<Car>();
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            cars.add(new Car(carName));
        }
        return cars;
    }

}
