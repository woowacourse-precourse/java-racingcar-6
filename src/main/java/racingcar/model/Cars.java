package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;


    public Cars(List<String> names){
        cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void moveOneStep(){
        for(Car car : cars){
            car.forward();
        }
    }

    public List<Car> getStatus() {
        return cars;
    }
}
