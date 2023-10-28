package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = new ArrayList<>(cars);
    }

    public Cars playRound(){
        List<Car> movedCars = new ArrayList<>();
        for(Car car : cars){
            movedCars.add(car.attemptMove());
        }
        return new Cars(movedCars);
    }

    public List<Car> toList(){
        return Collections.unmodifiableList(cars);
    }

}
