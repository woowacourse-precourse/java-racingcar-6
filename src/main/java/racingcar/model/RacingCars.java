package racingcar.model;

import java.util.ArrayList;

public class RacingCars {
    private final ArrayList<Car> CARS = new ArrayList<>();

    public RacingCars(ArrayList<String> cars){
        cars.forEach(car->CARS.add(new Car(car)));
    }
}
