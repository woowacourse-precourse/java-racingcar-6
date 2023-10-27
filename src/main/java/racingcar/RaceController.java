package racingcar;

import java.util.ArrayList;

public class RaceController {

    ArrayList<Car> cars = new ArrayList<>();

    public void initializeCars(String inputCar) {
        String[] inputCars = inputCar.split(",");
        for (String car : inputCars) {
            cars.add(new Car(car));
        }
    }


}
