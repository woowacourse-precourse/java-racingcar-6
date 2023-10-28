package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names){
        cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void forward(){
        for(Car car : cars){
            car.forward();
        }
    }
}
